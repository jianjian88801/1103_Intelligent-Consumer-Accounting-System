
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
 * 收入
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shouru")
public class ShouruController {
    private static final Logger logger = LoggerFactory.getLogger(ShouruController.class);

    @Autowired
    private ShouruService shouruService;


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
        PageUtils page = shouruService.queryPage(params);

        //字典表数据转换
        List<ShouruView> list =(List<ShouruView>)page.getList();
        for(ShouruView c:list){
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
        ShouruEntity shouru = shouruService.selectById(id);
        if(shouru !=null){
            //entity转view
            ShouruView view = new ShouruView();
            BeanUtils.copyProperties( shouru , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(shouru.getYonghuId());
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
    public R save(@RequestBody ShouruEntity shouru, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shouru:{}",this.getClass().getName(),shouru.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shouru.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShouruEntity> queryWrapper = new EntityWrapper<ShouruEntity>()
            .eq("yonghu_id", shouru.getYonghuId())
            .eq("shouru_uuid_number", shouru.getShouruUuidNumber())
            .eq("shouru_name", shouru.getShouruName())
            .eq("shouru_types", shouru.getShouruTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShouruEntity shouruEntity = shouruService.selectOne(queryWrapper);
        if(shouruEntity==null){
            shouru.setInsertTime(new Date());
            shouru.setCreateTime(new Date());
            shouruService.insert(shouru);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShouruEntity shouru, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shouru:{}",this.getClass().getName(),shouru.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shouru.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShouruEntity> queryWrapper = new EntityWrapper<ShouruEntity>()
            .notIn("id",shouru.getId())
            .andNew()
            .eq("yonghu_id", shouru.getYonghuId())
            .eq("shouru_uuid_number", shouru.getShouruUuidNumber())
            .eq("shouru_name", shouru.getShouruName())
            .eq("shouru_types", shouru.getShouruTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShouruEntity shouruEntity = shouruService.selectOne(queryWrapper);
        if(shouruEntity==null){
            shouruService.updateById(shouru);//根据id更新
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
        shouruService.deleteBatchIds(Arrays.asList(ids));
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
        try {
            List<ShouruEntity> shouruList = new ArrayList<>();//上传的东西
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
                            ShouruEntity shouruEntity = new ShouruEntity();
                            shouruEntity.setYonghuId(yonghuId);   //用户 要改的
                            shouruEntity.setShouruUuidNumber(String.valueOf(new Date().getTime()));                    //收入唯一编号 要改的
                            shouruEntity.setShouruName(data.get(0));                    //收入名称 要改的
                            shouruEntity.setShouruTypes(Integer.valueOf(data.get(1)));   //收入类型 要改的
                            shouruEntity.setShouruNumber(Double.valueOf(data.get(2)));                    //收入金额 要改的
                            shouruEntity.setShangjiaContent("无");//照片
                            shouruEntity.setShoruTime(simpleDateFormat.parse(data.get(3)));          //收入时间 要改的
                            shouruEntity.setInsertTime(date);//时间
                            shouruEntity.setCreateTime(date);//时间
                            shouruList.add(shouruEntity);


//                            //把要查询是否重复的字段放入map中
//                                //收入唯一编号
//                                if(seachFields.containsKey("shouruUuidNumber")){
//                                    List<String> shouruUuidNumber = seachFields.get("shouruUuidNumber");
//                                    shouruUuidNumber.add(data.get(0));//要改的
//                                }else{
//                                    List<String> shouruUuidNumber = new ArrayList<>();
//                                    shouruUuidNumber.add(data.get(0));//要改的
//                                    seachFields.put("shouruUuidNumber",shouruUuidNumber);
//                                }
                        }

//                        //查询是否重复
//                         //收入唯一编号
//                        List<ShouruEntity> shouruEntities_shouruUuidNumber = shouruService.selectList(new EntityWrapper<ShouruEntity>().in("shouru_uuid_number", seachFields.get("shouruUuidNumber")));
//                        if(shouruEntities_shouruUuidNumber.size() >0 ){
//                            ArrayList<String> repeatFields = new ArrayList<>();
//                            for(ShouruEntity s:shouruEntities_shouruUuidNumber){
//                                repeatFields.add(s.getShouruUuidNumber());
//                            }
//                            return R.error(511,"数据库的该表中的 [收入唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
//                        }
                        shouruService.insertBatch(shouruList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
