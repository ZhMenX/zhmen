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
    }
};
const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    //关闭eslint校验
    lintOnSave: false
})
