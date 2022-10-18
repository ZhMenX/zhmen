module.exports = {
  publicPath: '/',
  devServer: {
    // true 则热更新，false 则手动刷新，默认值为 true
    inline: true,
    // development server port 8000
    port: 8081,
    // 配置不同的后台API地址
    // proxy: {
    //   '/api': {
    //     target: 'http://localhost:8090/',
    //     ws: false,
    //     changeOrigin: true,
    //     pathRewrite: {
    //       '^/api': ''
    //     }
    //   }
    // }
  }
}
