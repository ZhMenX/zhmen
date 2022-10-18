import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Index from '../views/Index'
import Blogs from "@/views/Article/Blogs";
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
        // meta: {
        //   requireAuth: true
        // }
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

export default router
