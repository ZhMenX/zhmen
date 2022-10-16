import Vue from 'vue'
import Vuex from 'vuex'
import id from "element-ui/src/locale/lang/id";
//挂载vuex
Vue.use(Vuex)
//创建store实例
/*
	这里涉及一个代码风格的设计思想，将目录名称与要设置的对象名称命名为一样的名称，可以利用es6语法，实现快速导入。
*/
export const store = new Vuex.Store({
    namespaced:true,//开启命名空间
    state: {
        token: '',
        userInfo: JSON.parse(sessionStorage.getItem("userInfo")),
        id: 2,
    },
    mutations: {
        // set
        SET_TOKEN: (state, token) => {
            state.token = token
            localStorage.setItem("token", token)
        },
        SET_USERINFO: (state, userInfo) => {
            state.userInfo = userInfo
            sessionStorage.setItem("userInfo", JSON.stringify(userInfo))
        },
        REMOVE_INFO: (state) => {
            state.token = ''
            state.userInfo = {}
            localStorage.setItem("token", '')
            sessionStorage.setItem("userInfo", JSON.stringify(''))
        },
        SET_ID: state => {
            state.id = id
            localStorage.setItem("id",JSON.stringify(id));
        }

    },
    getters: {
        // get
        getUser: state => {
            return state.userInfo
        },
        getToken: state => {
            return state.token;
        },
        getID: state => {
            return state.id+1;
        }

    },
    actions: {
    },
    modules: {
    }
})

/*
* import Vue from 'vue';
import Vuex from 'vuex';
//挂载vuex
Vue.use(Vuex);
//创建store实例
const store = new Vuex.Store({
    state:{}, //相当于一个存储空间
    getters:{}, //state的计算数据 实现数据过滤的作用（get）
    mutations:{}，//设置state中的数据（set）
    actions:{},  //可以发送异步请求
    modules:{},  //拆分存储空间模块化
    plugins:{},  //拓展vuex功能
})
//导出store对象
export default store;

* */



