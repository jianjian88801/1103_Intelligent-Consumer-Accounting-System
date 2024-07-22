import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import shouru from '@/views/modules/shouru/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yusuan from '@/views/modules/yusuan/list'
    import zhichu from '@/views/modules/zhichu/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShouru from '@/views/modules/dictionaryShouru/list'
    import dictionaryYusuan from '@/views/modules/dictionaryYusuan/list'
    import dictionaryYusuanErji from '@/views/modules/dictionaryYusuanErji/list'
        import dictionaryYusuanErjiAddOrUpdate from '@/views/modules/dictionaryYusuanErji/add-or-update'//二级
    import dictionaryZhichu from '@/views/modules/dictionaryZhichu/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShouru',
        name: '收入类型',
        component: dictionaryShouru
    }
    ,{
        path: '/dictionaryYusuan',
        name: '预算类型',
        component: dictionaryYusuan
    }
    ,{
        path: '/dictionaryYusuanErji',
        name: '二级类型',
        component: dictionaryYusuanErji
    }
    ,{
        path: '/dictionaryYusuanErjiAddOrUpdate',
        name: '二级类型的新增修改页面',
        component: dictionaryYusuanErjiAddOrUpdate
    }
    ,{
        path: '/dictionaryZhichu',
        name: '支出类型',
        component: dictionaryZhichu
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/shouru',
        name: '收入',
        component: shouru
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/yusuan',
        name: '预算',
        component: yusuan
      }
    ,{
        path: '/zhichu',
        name: '支出',
        component: zhichu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
