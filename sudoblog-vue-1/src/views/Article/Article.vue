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
    <el-col
      :span="24"
      style="width: 100%; background-color: #ffffff; margin-top: 20px"
    >
      <el-divider></el-divider>
      <!--文章展示区-->
      <el-col
        :span="11"
        style="width: 855px; background-color: #eff3f5"
        :push="3"
      >
        <!--搜索栏-->
        <div
          style="width: 840px; height: 44px; background-color: #ffffff"
          class="el-breadcrumb"
        >
          <el-col :span="4">
            <div style="margin-top: 15px; width: 119px; height: 43px">
              <router-link to="/article">
                <span>全部</span>
                <span>（{{ pagination.total }}）</span>
              </router-link>
            </div>
          </el-col>
          <el-col :span="8" :push="12">
            <el-form
              :inline="true"
              :model="searchFrom"
              class="demo-form-inline"
              size="small"
              style="height: 58px"
            >
              <el-form-item>
                <el-input
                  v-model="titleByLike.title"
                  placeholder="请输入需要的内容"
                ></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="tableDataSearch(titleByLike)"
                  >查询</el-button
                >
              </el-form-item>
            </el-form>
          </el-col>
        </div>
        <div style="margin-top: 10px">
          <div>
            <el-col :span="24">
              <el-timeline>
                <el-timeline-item
                  color="hsv"
                  placement="top"
                  v-for="blog in blogs"
                  style="margin-right: 20px"
                >
                  <el-card>
                    <h4>
                      <router-link
                        :to="{
                          name: 'ArticleDetail',
                          params: { blogId: blog.id },
                        }"
                      >
                        {{ blog.title }}
                      </router-link>
                    </h4>
                    <p>{{ blog.description }}</p>
                  </el-card>
                </el-timeline-item>
              </el-timeline>
            </el-col>
            <el-col :span="7" :push="5">
              <el-pagination
                background
                layout="prev, pager, next"
                :current-page="pagination.currentPage"
                :page-size="pagination.pageSize"
                :total="pagination.total"
                @current-change="page"
                style="margin-right: 50px"
              >
              </el-pagination>
            </el-col>
          </div>
        </div>
      </el-col>
      <!--右边侧栏-->
      <el-col
        :span="4"
        :push="4"
        style="width: 285px; background-color: #eff3f5"
      >
        <el-col :span="24" style="height: 42px; background-color: #409eff">
          <el-col :push="7" style="margin-top: 4px">
            <el-button type="primary" size="medium" @click="arAdd()"
              >发表文章</el-button
            >
          </el-col>
        </el-col>
        <el-col :span="24">
          <el-divider></el-divider>
        </el-col>
        <el-col :span="24" style="height: 92px; background-color: #ffffff">
          <div style="height: 92px; background-color: #ffffff">
            <el-col :span="10" :push="5">
              <div style="margin-left: 30px">
                <h4 style="color: #409eff">文章推荐</h4>
              </div>
            </el-col>
          </div>
        </el-col>
        <el-col :span="24">
          <el-divider></el-divider>
        </el-col>
        <el-col :span="24">
          <el-card class="box-card">
            <div v-for="o in blogs" :key="o.id">
              <router-link
                :to="{ name: 'ArticleDetail', params: { blogId: o.id } }"
              >
                {{ o.title }}
              </router-link>
            </div>
          </el-card>
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
    </el-col>
  </el-row>
</template>

<script>
import la from "../../components/Leader";
import ArticleDetail from "./ArticleDetail";
import user from "../../components/UserLeader";
import { getToken } from "@/api/auth";
export default {
  name: "Article",
  components: {
    la,
    ArticleDetail,
    user,
  },
  created() {
    this.page(1);
  },
  data() {
    return {
      pagination: {
        currentPage: 1,
        total: null,
        pageSize: 5,
      },
      searchFrom: {
        currentPage: null,
        pageSize: null,
      },
      blogs: [],
      titleByLike: {
        id: "",
        title: "",
        description: "",
        content: "",
        total: "",
      },
      tableData: [
        {
          id: "",
          title: "",
          description: "",
          content: "",
          total: "",
          currentPage: null,
          pageSize: null,
        },
      ],
      activeName: "second",
    };
  },
  methods: {
    tableDataSearch() {
      this.blogs = [];
      this.$http
        .get("/articleLike", { params: this.titleByLike })
        .then((res) => {
          for (let i in res.data.data) {
            this.blogs.push(res.data.data[i]);
          }
          console.log(res.data.data);
          this.pagination.total = res.data.total;
          this.tableData = res.data.data;
          if (res.data.data.length === 0) {
            alert("根据该关键字找不到对应内容");
            this.$router.go(0);
          }
        })
        .catch((err) => {
          console.log("请求错误");
        });
    },
    arAdd() {
      this.$router.push({ name: "ArticleAdd" });
    },
    page(currentPage) {
      this.pagination.currentPage = currentPage;
      this.search();
    },
    search: async function () {
      const _this = this;
      this.searchFrom.currentPage = this.pagination.currentPage;
      this.searchFrom.pageSize = this.pagination.pageSize;
      let page = {
        currentPage: this.searchFrom.currentPage,
        pageSize: this.searchFrom.pageSize,
      };
      this.$http
        .get("/article", { params: this.searchFrom })
        .then(
          function (res) {
            _this.blogs = [];
            for (let i in res.data.data.content) {
              _this.blogs.push(res.data.data.content[i]);
            }
            _this.pagination.total = res.data.total;
            _this.tableData = res.data.data;
          }.bind(this)
        )
        .catch((err) => {
          console.log("请求错误");
        });
    },
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
text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}

.box-card {
  width: 100%;
}
</style>
