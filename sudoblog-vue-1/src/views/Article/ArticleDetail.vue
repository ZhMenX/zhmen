<template>
  <el-row :gutter="10">
    <el-col :span="24">
      <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1"
      ><img class="mlogo" src="../../assets/image/background.jpg" alt="LOGO" />
      </el-col>
      <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11" :push="11">
        <la></la>
      </el-col>
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
          <h2> {{ blog.title }}</h2>
          <el-divider></el-divider>
          <div class="markdown-body" v-html="blog.content" style="border: #647eff"></div>
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
// 导入组件 及 组件样式
import 'mavon-editor/dist/css/index.css'
import la from "../../components/Leader";
import beforeLogin from "@/components/beforeLogin";
import afterLogin from "@/components/afterLogin";
import { getIsAdmin, getToken } from "@/api/auth";
export default {
  name: "ArticleDetail",
  components: {
    la,
  },
  data() {
    return {
      blog: {
        id: "",
        title: "",
        content: ""
      },
      comName: 'beforeLogin',
    }
  },
  created() {
    const blogId = this.$route.params.blogId
    console.log(blogId)
    const _this = this
    this.$http.get('/article/' + blogId).then(res => {
      const blog = res.data.data
      _this.blog.id = blog.id
      _this.blog.title = blog.title
      const MardownIt = require("markdown-it");
      const md = new MardownIt();
      _this.blog.content = md.render(blog.content)
    })

  },
  methods: {
    goBack() {
      this.$router.push({name: "Article"})
    },
    watchToken(token){
      if (token!=null){
        this.comName = 'afterLogin'
      }
      else {
        this.comName = 'beforeLogin'
      }
    },
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
  },
};
</script>

<style scoped>
.mlogo {
  height: 40px;
  margin-top: 18px;
}
</style>
