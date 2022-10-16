<template>
  <el-row :gutter="10">
    <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1"
      ><img class="mlogo" src="../assets/image/background.jpg" alt="LOGO" />
    </el-col>
    <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11" :push="11">
      <la></la>
    </el-col>
    <el-col>
      <div class="demo-image__placeholder">
        <div class="block">
          <el-image :src="src">
            <div slot="placeholder" class="image-slot">
              加载中<span class="dot">...</span>
            </div>
          </el-image>
        </div>
      </div>
    </el-col>
    <el-col :push="3">
      <el-descriptions title="加入我们">
        <el-descriptions-item label="联系人">姜同学</el-descriptions-item>
        <el-descriptions-item label="联系电话"
          >18100000000</el-descriptions-item
        >
        <el-descriptions-item label="技术支持"> Ctrl C/V </el-descriptions-item>
        <el-descriptions-item label="公司地址"
          >江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item
        >
        <el-descriptions-item label="站长微信">
          <div class="demo-image__preview">
            <el-image
              style="width: 58px; height: 58px"
              :src="url1"
              :preview-src-list="srcList"
            >
            </el-image>
          </div>
        </el-descriptions-item>
        <el-descriptions-item label="站长抖音">
          <div class="demo-image__preview">
            <el-image
              style="width: 50px; height: 50px"
              :src="url2"
              :preview-src-list="srcList"
            >
            </el-image>
          </div>
        </el-descriptions-item>
      </el-descriptions>
    </el-col>
  </el-row>
</template>

<script>
import la from "../components/Leader";
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "About",
  components: {
    la,
  },
  data() {
    return {
      src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
      url1: "https://pic4.zhimg.com/cb87e679af17ef61a8d1efda05785dab_r.jpg",
      url2: "https://img.zcool.cn/community/0144255afb8e64a801207ab475a594.jpg@1280w_1l_2o_100sh.jpg",
      srcList: [
        "https://pic4.zhimg.com/cb87e679af17ef61a8d1efda05785dab_r.jpg",
        "https://img.zcool.cn/community/0144255afb8e64a801207ab475a594.jpg@1280w_1l_2o_100sh.jpg",
      ],
    };
  },
};
</script>

<style scoped>
.mlogo {
  height: 40px;
  margin-top: 18px;
}
</style>
