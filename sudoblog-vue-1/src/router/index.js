import Vue from "vue";
import VueRouter from "vue-router";
import el from "element-ui/src/locale/lang/el";
import store from "@/store";
import { getFromPath, getToken, setFromPath } from "@/api/auth";
Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "Index",
        component: () => import("../views/Index"),
    },
    {
        path: "/learn",
        name: "Learn",
        component: () => import("../views/Learn/Learn"),
    },
    {
        path: "/login",
        name: "Login",
        component: () => import("../components/Login"),
    },
    {
        path: "/register",
        name: "Register",
        component: () => import("../components/Register"),
    },
    {
        path: "/about",
        name: "About",
        component: () => import("../views/About"),
    },
    {
        path: "/personalCenter",
        name: "PersonalCenter",
        component: () => import("../views/Personal/PersonalCenter"),
        meta: {
            title: '',
            requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
        }
    },
    {
        path: "/discussAdd",
        name: "DiscussAdd",
        component: () => import("../views/Discuss/DiscussAdd"),
        meta: {
            title: '',
            requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
        }
    },
    {
        path: "/discuss",
        name: "Discuss",
        component: () => import("../views/Discuss/Discuss"),
        meta: {
            title: '',
            requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
        },

    },
    {
        path: "/discussDetail",
        name: "DiscussDetail",
        component: () => import("../views/Discuss/DiscussDetail"),
        meta: {
            title: '',
            requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
        }
    },
    {
        path: "/article",
        name: "Article",
        component: () => import("../views/Article/Article"),
        meta: {
            title: '',
            requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
        }
    },
    {
        path: "/detail",
        name: "ArticleDetail",
        component: () => import("../views/Article/ArticleDetail"),
        meta: {
            title: '',
            requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
        }
    },
    {
        path:"/learnDetail",
        name: "LearnDetail",
        component: () => import("../views/Learn/LearnDetail"),
        children: [
            {
                path: 'java',
                name: 'java',
                component: () => import("../views/Learn/Learn_Java")
            }
        ]
    },
    {
        path: "/admin",
        name: "admin",
        component: () => import("../views/Admin/Administration"),
    }
];

const router = new VueRouter({
    routes,
});
router.beforeEach(async (to,from,next)=>{
   if (to.matched.some(route => route.meta.requiredAuth)){  // // 判断该路由是否需要登录权限
       if (getToken() === null){
           next({
               path: '/login',
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

export default router;

