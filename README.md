# 简介

这是个词典，用于古汉语查询

# 架构

使用MVP架构模式

# 用到的第三方库

1. 网络请求  ~~Volley~~~ 上层全部用Retrofit 来写，底层用okhttp来请求，如果请求返回数据格式有问题，添加okhttp的拦截器来修改格式
2. 图片加载 Glide 
3. 依赖注入  ButterKnife
4. 事件传递 EventBus
5. 本地数据库准备用 [ORMLite](https://www.jianshu.com/p/231027465aab)，[Room](https://www.jianshu.com/p/cfde3535233d)   
6. web tornado  ? think php 

## 关于混淆

很奇怪啊，我们没写屏蔽ButterKnife的混淆相关的配置，他竟然不混淆

默认混淆配置在 ./build/intermediates/proguard-files/proguard-defaults.txt-3.2.1