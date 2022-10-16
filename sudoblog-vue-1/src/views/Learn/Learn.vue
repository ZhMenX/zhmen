<template>
  <el-row :gutter="10">
    <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1"
      ><img class="mlogo" src="../../assets/image/background.jpg" alt="LOGO" />
    </el-col>
    <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11" :push="11">
      <la></la>
    </el-col>
    <el-col :xs="2" :sm="2" :md="4" :lg="3" :xl="1" :push="9">
      <user></user>
    </el-col>
    <el-col :span="24">
      <!-- 轮播图 -->
      <div class="learn_back">
        <el-col :span="24">
          <el-carousel :interval="4000" type="card" height="200px">
            <el-carousel-item v-for="item in 6" :key="item">
              <h3 class="medium">{{ item }}</h3>
            </el-carousel-item>
          </el-carousel>
        </el-col>
      </div>
      <el-col :span="24" style="margin-top: 15px; background-color: #eff3f5">
        <div style="width: 1200px">
          <el-tabs type="card" style="margin-left: 200px" :stretch="true">
            <el-tab-pane label="JAVA学习">
              <el-col :span="24">
                <div style="height: 300px; width: auto">
                  <el-col :span="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <router-link type="info" :to="{name: 'LearnDetail', params: {lid: 1}}">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >JAVA入门</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </router-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="3">
                    <div style="width: 256px; background-color: #b1bece">
                      <router-link type="info" :to="{name: 'LearnDetail', params: {lid: 2}}">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >面向对象</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </router-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <router-link type="info" :to="{name: 'LearnDetail', params: {lid: 3}}">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >类与对象</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </router-link>
                    </div>
                  </el-col>
                </div>
              </el-col>
              <el-col :span="24">
                <div style="height: 300px; width: auto">
                  <el-col :span="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <router-link type="info" :to="{name: 'LearnDetail', params: {lid: 4}}">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >接口与继承</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </router-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="3">
                    <div style="width: 256px; background-color: #b1bece">
                      <router-link type="info" :to="{name: 'LearnDetail', params: {lid: 5}}">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >异常处理</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </router-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <router-link type="info" :to="{name: 'LearnDetail', params: {lid: 6}}">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >IO流</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </router-link>
                    </div>
                  </el-col>
                </div>
              </el-col>
              <el-col :span="24">
                <div style="height: 300px; width: auto">
                  <el-col :span="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <router-link type="info" :to="{name: 'LearnDetail', params: {lid: 7}}">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >集合框架</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </router-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="3">
                    <div style="width: 256px; background-color: #b1bece">
                      <router-link type="info" :to="{name: 'LearnDetail', params: {lid: 8}}">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >泛型</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </router-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <router-link type="info" :to="{name: 'LearnDetail', params: {lid: 9}}">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >Lambda</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </router-link>
                    </div>
                  </el-col>
                </div>
              </el-col>
              <el-backtop :bottom="100">
                <div
                  style="
                     {
                      height: 100%;
                      width: 100%;
                      background-color: #f2f5f6;
                      box-shadow: 0 0 6px rgba(0, 0, 0, 0.12);
                      text-align: center;
                      line-height: 40px;
                      color: #1989fa;
                    }
                  "
                >
                  UP
                </div>
              </el-backtop>
            </el-tab-pane>
            <el-tab-pane label="Spring">
              <el-col :span="24">
                <div style="height: 300px; width: auto">
                  <el-col :span="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习Spring</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="3">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习Spring</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习Spring</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                </div>
              </el-col>
              <el-col :span="24">
                <div style="height: 300px; width: auto">
                  <el-col :span="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习Spring</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="3">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习Spring</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习Spring</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                </div>
              </el-col>
              <el-col :span="24">
                <div style="height: 300px; width: auto">
                  <el-col :span="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习Spring</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="3">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习Spring</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习Spring</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                </div>
              </el-col>
              <el-backtop :bottom="100">
                <div
                  style="
                     {
                      height: 100%;
                      width: 100%;
                      background-color: #f2f5f6;
                      box-shadow: 0 0 6px rgba(0, 0, 0, 0.12);
                      text-align: center;
                      line-height: 40px;
                      color: #1989fa;
                    }
                  "
                >
                  UP
                </div>
              </el-backtop>
            </el-tab-pane>
            <el-tab-pane label="MySQL">
              <el-col :span="24">
                <div style="height: 300px; width: auto">
                  <el-col :span="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习MySQL</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="3">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习MySQL</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习MySQL</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                </div>
              </el-col>
              <el-col :span="24">
                <div style="height: 300px; width: auto">
                  <el-col :span="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习MySQL</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="3">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习MySQL</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习MySQL</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                </div>
              </el-col>
              <el-col :span="24">
                <div style="height: 300px; width: auto">
                  <el-col :span="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习MySQL</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="3">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习MySQL</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >学习MySQL</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                </div>
              </el-col>
              <el-backtop :bottom="100">
                <div
                  style="
                     {
                      height: 100%;
                      width: 100%;
                      background-color: #f2f5f6;
                      box-shadow: 0 0 6px rgba(0, 0, 0, 0.12);
                      text-align: center;
                      line-height: 40px;
                      color: #1989fa;
                    }
                  "
                >
                  UP
                </div>
              </el-backtop>
            </el-tab-pane>
            <el-tab-pane label="前端基础">
              <el-col :span="24">
                <div style="height: 300px; width: auto">
                  <el-col :span="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >前端基础</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="3">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >前端基础</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >前端基础</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                </div>
              </el-col>
              <el-col :span="24">
                <div style="height: 300px; width: auto">
                  <el-col :span="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >前端基础</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="3">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >前端基础</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >前端基础</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                </div>
              </el-col>
              <el-col :span="24">
                <div style="height: 300px; width: auto">
                  <el-col :span="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >前端基础</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="3">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >前端基础</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                  <el-col :span="6" :push="6">
                    <div style="width: 256px; background-color: #b1bece">
                      <el-link type="info" href="https://baidu.com">
                        <div class="block">
                          <span
                            class="demonstration"
                            style="margin-left: 70px; font-size: x-large"
                            >前端基础</span
                          >
                          <el-image :src="src"></el-image>
                        </div>
                      </el-link>
                    </div>
                  </el-col>
                </div>
              </el-col>
              <el-backtop :bottom="100">
                <div
                  style="
                     {
                      height: 100%;
                      width: 100%;
                      background-color: #f2f5f6;
                      box-shadow: 0 0 6px rgba(0, 0, 0, 0.12);
                      text-align: center;
                      line-height: 40px;
                      color: #1989fa;
                    }
                  "
                >
                  UP
                </div>
              </el-backtop>
            </el-tab-pane>
          </el-tabs>
        </div>
      </el-col>
    </el-col>
  </el-row>
</template>
<script>
import la from "../../components/Leader";
import FancyButton from "@/components/FancyButton";
import user from "@/components/UserLeader";
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Learn",
  components: {
    la,
    FancyButton,
    user,
  },
  data() {
    return {
      activeName: "second",
      activeNames: ["1"],
      src: "https://pic2.zhimg.com/v2-fa80b1dc7726cec904e4f21471cd60d2_720w.jpg?source=172ae18b",
      userInfo: this.$store.getters.getUser,
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
  },
};
</script>

<style scoped>
.mlogo {
  height: 40px;
  margin-top: 18px;
}
.learn_back {
  width: 1532px;
  height: auto;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 300px;
  margin-top: 30px;
}
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
  background-image: url("../../assets/image/vg9oz8.jpg");
  background-size: cover;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
  background-image: url("../../assets/image/background.jpg");
  background-size: cover;
}
</style>
