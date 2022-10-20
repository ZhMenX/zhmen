import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Index from '../views/Index'
import Blogs from "@/views/Article/Blogs";
import {getToken} from "../api/auth";
Vue.use(VueRouter)

const routes = [
  {
    path: '/index',
    name: 'Index',
    component: Index,
    iconCls: 'el-icon-tickets',
    children:[
      {
        path: '/Article/Blogs',
        name: '商品管理',
        component: Blogs,
        meta: {
          requireAuth: true
        }
      }
    ]

  },
  {
    path: '/',
    name: 'Login',
    component: Login
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach(async (to,from,next)=>{
  if (to.matched.some(route => route.meta.requiredAuth)){  // // 判断该路由是否需要登录权限
    if (getToken() === null){
      next({
        path: '/',
        query: {redirect: to.fullPath}, // 将跳转的路由path作为参数，登录成功后跳转到该路由
      })
    }
    else{
      next();
    }
  }
  else {
    next();
  }
});

export default router
