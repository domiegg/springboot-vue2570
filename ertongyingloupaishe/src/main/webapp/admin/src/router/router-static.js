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
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import fuzhuangshipin from '@/views/modules/fuzhuangshipin/list'
    import liuyan from '@/views/modules/liuyan/list'
    import news from '@/views/modules/news/list'
    import paishexiangmu from '@/views/modules/paishexiangmu/list'
    import paishexuantu from '@/views/modules/paishexuantu/list'
    import shangpin from '@/views/modules/shangpin/list'
    import yonghu from '@/views/modules/yonghu/list'
    import zhiyuan from '@/views/modules/zhiyuan/list'
    import zijinxinxi from '@/views/modules/zijinxinxi/list'
    import dictionaryFuzhuangshipin from '@/views/modules/dictionaryFuzhuangshipin/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionaryPaishexiangmu from '@/views/modules/dictionaryPaishexiangmu/list'
    import dictionaryPaishexuantu from '@/views/modules/dictionaryPaishexuantu/list'
    import dictionaryPaisheyudingOrder from '@/views/modules/dictionaryPaisheyudingOrder/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangpin from '@/views/modules/dictionaryShangpin/list'
    import dictionaryYonghushenfen from '@/views/modules/dictionaryYonghushenfen/list'
    import dictionaryZijinxinxi from '@/views/modules/dictionaryZijinxinxi/list'





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
        path: '/dictionaryFuzhuangshipin',
        name: '服装类型',
        component: dictionaryFuzhuangshipin
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionaryPaishexiangmu',
        name: '拍摄项目',
        component: dictionaryPaishexiangmu
    }
    ,{
        path: '/dictionaryPaishexuantu',
        name: '状态',
        component: dictionaryPaishexuantu
    }
    ,{
        path: '/dictionaryPaisheyudingOrder',
        name: '订单类型',
        component: dictionaryPaisheyudingOrder
    }
    ,{
        path: '/dictionarySex',
        name: '性别',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangpin',
        name: '套餐类型',
        component: dictionaryShangpin
    }
    ,{
        path: '/dictionaryYonghushenfen',
        name: '身份',
        component: dictionaryYonghushenfen
    }
    ,{
        path: '/dictionaryZijinxinxi',
        name: '类型',
        component: dictionaryZijinxinxi
    }


    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/fuzhuangshipin',
        name: '服装饰品',
        component: fuzhuangshipin
      }
    ,{
        path: '/liuyan',
        name: '留言版',
        component: liuyan
      }
    ,{
        path: '/news',
        name: '公告信息',
        component: news
      }
    ,{
        path: '/paishexiangmu',
        name: '拍摄预定',
        component: paishexiangmu
      }
    ,{
        path: '/paishexuantu',
        name: '拍摄选图',
        component: paishexuantu
      }
    ,{
        path: '/shangpin',
        name: '商品',
        component: shangpin
      }
    ,{
        path: '/yonghu',
        name: '顾客',
        component: yonghu
      }
    ,{
        path: '/zhiyuan',
        name: '职员',
        component: zhiyuan
      }
    ,{
        path: '/zijinxinxi',
        name: '资金信息',
        component: zijinxinxi
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
