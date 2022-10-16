const webpack = require("webpack");
module.exports = {
    devServer: {
        configureWebpack: {
            plugins: [
                new webpack.ProvidePlugin({
                    $: "jquery",
                    jQuery: "jquery",
                    "window.jQuery": "jquery",
                    Popper: ["popper.js", "default"]
                })
            ]
        },
        proxy: {
            '/api': {
                target: 'http://localhost:8090',
                changeOrigin: true,
                ws: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        }
    }
};
const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    //关闭eslint校验
    lintOnSave: false
})