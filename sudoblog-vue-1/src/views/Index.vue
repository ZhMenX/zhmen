<template>
  <el-row :gutter="10">
    <el-col :span="24">
      <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1"
        >
        <router-link to="/">
          <img class="mlogo" src="../assets/image/background.jpg" alt="LOGO"/>
        </router-link>
      </el-col>
      <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11" :push="11"
        ><el-menu
          :default-active="activeIndex"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
        >
          <el-menu-item index="1">
            <router-link to="/">首页</router-link>
          </el-menu-item>
          <el-menu-item index="2">
            <router-link to="/learn">学习</router-link>
          </el-menu-item>
          <el-menu-item index="3">
          <router-link to="/discuss">技术探讨</router-link>
          </el-menu-item>
          <el-menu-item index="4">
            <router-link to="/article">博客文章</router-link>
          </el-menu-item>
        </el-menu>
      </el-col>
      <el-col ::xs="8" :sm="6" :md="4" :lg="3" :xl="1" :push="9">
        <el-row style="margin-top: 9px">
          <keep-alive>
            <component :is="comName"></component>
          </keep-alive>
        </el-row>
      </el-col>
    </el-col>

    <el-col :span="24">
      <div class="M_one">
        <img class="Mlogo" src="../assets/image/background.jpg" alt="图标" />
      </div>
    </el-col>
    <el-col :span="24">
      <div style="height: 20px; width: 860px; margin-left: 470px">
        <p style="font-size: 27px; font-style: normal">
          为每个想学Java的人提供一个少走弯路的平台
        </p>
      </div>
    </el-col>
    <el-col :span="24">
      <div style="height: 20px; width: 860px; margin-left: 700px">
        <p style="font-size: 15px; font-style: normal">向阳而生</p>
      </div>
    </el-col>
    <el-col :span="24">
      <div
        class="btn"
        style="margin-top: 50px; margin-left: 580px; margin-bottom: 20px"
      >
        <el-button type="success" round @click="linkRouter('Learn')">
          学习启程
        </el-button>
        <el-button type="primary" round @click="linkRouter('Article')">
          观看文章
        </el-button>
        <keep-alive>
          <component :is="adName"></component>
        </keep-alive>
      </div>
    </el-col>
  </el-row>
</template>
<script>
import beforeLogin from "@/components/beforeLogin";
import afterLogin from "@/components/afterLogin";
import beforeAdmin from "@/components/beforeAdmin";
import afterAdmin from "@/components/afterAdmin";
import { getIsAdmin, getToken } from "@/api/auth";
import UserLeader from "@/components/UserLeader";
export default {
  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1",
      showLogin:false,
      comName: 'beforeLogin',
      adName:'beforeAdmin',
      token: getToken(),
      isAdmin: getIsAdmin(),
    };
  },
  created() {
    this.watchToken(getToken());
    console.log(getToken());
    this.watchAdmin(getIsAdmin())
  },
  components:{
    beforeLogin,
    afterLogin,
    beforeAdmin,
    UserLeader,
    afterAdmin
  },
  methods: {

    watchToken(token){
      if (token!=null){
        this.comName = 'afterLogin'
      }
      else {
        this.comName = 'beforeLogin'
      }
    },
    watchAdmin(isAdmin){
      if (isAdmin === '1' ){
        this.adName = 'afterAdmin'
      }
      else {
        this.adName = 'beforeAdmin'
      }
    },
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    linkRouter: function (viewName) {
      this.$router.push({ name: viewName });
    },
  },
};
</script>

<style scoped>
.mlogo {
  height: 40px;
  margin-top: 18px;
}
.Mlogo {
  height: 60px;
  width: 280px;
}
.M_one {
  margin-top: 100px;
  margin-left: 600px;
  margin-bottom: 20px;
  height: 60px;
  width: 280px;
}
</style>
