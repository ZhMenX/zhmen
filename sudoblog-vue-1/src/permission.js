import router from "./router";
import { getToken } from "@/api/auth";

// // 路由判断登录 根据路由配置文件的参数


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



// router.beforeEach((to, from, next) => {
//
//     if (to.matched.some(record => record.meta.requireAuth)) { // 判断该路由是否需要登录权限
//
//         const token = localStorage.getItem("token")
//         console.log("------------" + token)
//
//         if (token) { // 判断当前的token是否存在 ； 登录存入的token
//             if (to.path === '/login') {
//
//             } else {
//                 next()
//             }
//         } else {
//             next({
//                 path: '/login'
//             })
//         }
//     } else {
//         next()
//     }
// })
