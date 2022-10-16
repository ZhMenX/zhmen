import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import axios from "axios";
import { store } from "./store/index";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";

Vue.use(ElementUI);
Vue.config.productionTip = false;
Vue.prototype.$http = axios;
Vue.prototype.$qs = qs
import mavonEditor from 'mavon-editor'

Vue.use(mavonEditor)
Vue.use(store)
import "./axios"
import "./permission"
import qs from "qs";


new Vue({
    store,
    router,
    render: (h) => h(App),
}).$mount("#app");
