import axios from 'axios'
import Element from 'element-ui'
import { getToken } from "@/api/auth";


axios.defaults.baseURL = 'http://localhost:8090'

// 前置拦截
axios.interceptors.request.use(
    config => {
        //是否需要设置token
        // const isToken = (config.headers || {}).isToken === false
        // let user = localStorage.getItem("userInfo") ? JSON.parse(localStorage.getItem("userInfo")) : null
        // let token = localStorage.getItem("token");
        // if (user!=null&& isToken){
        //   config.headers['token'] = token;
        // }
        const isToken = (config.headers || {}).isToken === false
        config.headers.contentType = "application/json; charset=utf-8"
        // do something before request is sent
        if (getToken() && !isToken) {
            config.headers.token = getToken()
        }
        return config;
    },
    error => {
        console.log("请求出错，错误信息如下：");
        console.log(error);
        return Promise.reject(error);
    }
)

axios.interceptors.response.use(
    response => {
        let res = response.data;

        console.log("=================")
        console.log(res)
        console.log("=================")


        if (res.code === 200) {
            return response;
        } else {
            Element.Message.error('错了哦，这是一条错误消息', {duration: 3 * 1000})
            return Promise.reject(res.msg)
        }
    },
    function(error) {
        if (error.response.data.code === 401){
            this.router.push("/")
        }
    }
)
