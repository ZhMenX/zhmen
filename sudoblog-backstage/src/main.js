import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Element from 'element-ui'
import axios from 'axios'
import qs from "qs";
Vue.prototype.$qs = qs
import VueBus from 'vue-bus'
Vue.use(VueBus)
import mavonEditor from 'mavon-editor'
Vue.use(mavonEditor)
import "element-ui/lib/theme-chalk/index.css"
import 'mavon-editor/dist/css/index.css'

import "./axios"
import "./permission"
Vue.prototype.$http = axios;

Vue.use(Element)


Vue.config.productionTip = false
Vue.prototype.$axios = axios

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
