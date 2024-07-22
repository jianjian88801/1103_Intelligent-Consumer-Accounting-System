
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 支出
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhichu")
public class ZhichuController {
    private static final Logger logger = LoggerFactory.getLogger(ZhichuController.class);

    @Autowired
    private ZhichuService zhichuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = zhichuService.queryPage(params);

        //字典表数据转换
        List<ZhichuView> list =(List<ZhichuView>)page.getList();
        for(ZhichuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhichuEntity zhichu = zhichuService.selectById(id);
        if(zhichu !=null){
            //entity转view
            ZhichuView view = new ZhichuView();
            BeanUtils.copyProperties( zhichu , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(zhichu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhichuEntity zhichu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhichu:{}",this.getClass().getName(),zhichu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            zhichu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZhichuEntity> queryWrapper = new EntityWrapper<ZhichuEntity>()
            .eq("yonghu_id", zhichu.getYonghuId())
            .eq("zhichu_uuid_number", zhichu.getZhichuUuidNumber())
            .eq("zhichu_name", zhichu.getZhichuName())
            .eq("zhichu_types", zhichu.getZhichuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhichuEntity zhichuEntity = zhichuService.selectOne(queryWrapper);
        if(zhichuEntity==null){
            zhichu.setInsertTime(new Date());
            zhichu.setCreateTime(new Date());
            zhichuService.insert(zhichu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhichuEntity zhichu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhichu:{}",this.getClass().getName(),zhichu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            zhichu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ZhichuEntity> queryWrapper = new EntityWrapper<ZhichuEntity>()
            .notIn("id",zhichu.getId())
            .andNew()
            .eq("yonghu_id", zhichu.getYonghuId())
            .eq("zhichu_uuid_number", zhichu.getZhichuUuidNumber())
            .eq("zhichu_name", zhichu.getZhichuName())
            .eq("zhichu_types", zhichu.getZhichuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhichuEntity zhichuEntity = zhichuService.selectOne(queryWrapper);
        if(zhichuEntity==null){
            zhichuService.updateById(zhichu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zhichuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ZhichuEntity> zhichuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZhichuEntity zhichuEntity = new ZhichuEntity();
                            zhichuEntity.setYonghuId(yonghuId);   //用户 要改的
                            zhichuEntity.setZhichuUuidNumber(String.valueOf(new Date().getTime()));                    //支出唯一编号 要改的
                            zhichuEntity.setZhichuName(data.get(0));                    //支出名称 要改的
                            zhichuEntity.setZhichuTypes(Integer.valueOf(data.get(1)));   //支出类型 要改的
                            zhichuEntity.setZhichuNumber(Double.valueOf(data.get(2)));                    //支出金额 要改的
                            zhichuEntity.setShangjiaContent("");//详情
                            zhichuEntity.setShoruTime(simpleDateFormat.parse(data.get(3)));          //支出时间 要改的
                            zhichuEntity.setInsertTime(date);//时间
                            zhichuEntity.setCreateTime(date);//时间
                            zhichuList.add(zhichuEntity);


                            //把要查询是否重复的字段放入map中
                                //支出唯一编号
                                if(seachFields.containsKey("zhichuUuidNumber")){
                                    List<String> zhichuUuidNumber = seachFields.get("zhichuUuidNumber");
                                    zhichuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhichuUuidNumber = new ArrayList<>();
                                    zhichuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhichuUuidNumber",zhichuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //支出唯一编号
                        List<ZhichuEntity> zhichuEntities_zhichuUuidNumber = zhichuService.selectList(new EntityWrapper<ZhichuEntity>().in("zhichu_uuid_number", seachFields.get("zhichuUuidNumber")));
                        if(zhichuEntities_zhichuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhichuEntity s:zhichuEntities_zhichuUuidNumber){
                                repeatFields.add(s.getZhichuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [支出唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhichuService.insertBatch(zhichuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
