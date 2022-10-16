<template>

  <el-row :gutter="10">
    <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1"
    ><img class="mlogo" src="../../assets/image/background.jpg" alt="LOGO" />
    </el-col>
    <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11" :push="11">
      <la></la>
    </el-col>
    <!--文章详情界面-->
    <el-col :span="24">
      <el-divider></el-divider>
      <el-page-header @back="goBack" content="详情页面">
      </el-page-header>
    </el-col>
    <el-col>
      <el-col :span="16":push="4">
        <div>
          <h2> {{ learn.title }}</h2>
          <el-divider></el-divider>
          <div class="markdown-body" v-html="learn.content"></div>
        </div>
      </el-col>
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
  </el-row>
</template>

<script>
import la from "../../components/Leader";
import FancyButton from "@/components/FancyButton";
import user from "@/components/UserLeader";
import MardownIt from "markdown-it";
export default {
  name: "LearnDetail",
  components: {
    la,
    FancyButton,
    user,
  },
  data() {
    return {
      learn: {
        lId: "",
        title: "",
        content: ""
      },
      id:null,
      ownBlog: false
    }
  },
  created() {
    const _this = this
    this.id =this.$route.params.lid;
    this.$http.get('/learn/' + this.id,{headers: {isToken: false}}).then(res => {
      const comment = res.data.data[0]
      _this.learn.lId = comment.lid
      _this.learn.title = comment.title
      const MardownIt = require("markdown-it");
      const md = new MardownIt();
      _this.learn.content = md.render(comment.content)

    })
  },
  methods: {
    goBack() {
      this.$router.push({name: "Learn"})
    }
  }
};
</script>

<style scoped>
.mlogo {
  height: 40px;
  margin-top: 18px;
}
</style>