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
    <el-col :span="24"
            style="width: 100%; background-color: #ffffff; margin-top: 20px">
      <el-col :span="11"
              style="width: 855px; background-color: #eff3f5"
              :push="3">
        <div style="margin-top: 10px">
          <p style="font-size: large">JAVA技术讨论区   |  Comments</p>
          <el-col :span="24">
            <div>
              <el-card>
                <div v-for="c in comments" :key="c.dsId" class="text item">
                  <h4>
                    <router-link :to="{name: 'DiscussDetail', params: {cid: c.dsId}}">
                      {{c.title}}
                    </router-link>
                  </h4>
                  <p>{{c.description}}</p>
                </div>
              </el-card>
            </div>
          </el-col>
        </div>
      </el-col>

      <el-col :span="6" style="background-color: #eff3f5" :push="4">
        <div style="height: auto;width: 100%">
          <div style="color: #647eff;width: 100px;margin-left: 130px;margin-bottom: 30px;margin-top: 20px">
            知识小贴士
          </div>
          <div>
            <el-collapse v-model="activeNames" @change="handleChange">
              <el-collapse-item title="面向过程和面向对象的区别" name="1">
                <div>1,面向过程性能比面向对象高。因为类调用时需要实例化，开销比较大，比较耗费资源，所以当性能是最重要的考量因素的时候，比如单片机，嵌入式开发，Linux/Unix等一般采用面向过程开发。但面向过程没有面向对象易于维护，易于复用，易于拓展；</div>
                <div>2,面向对象易于维护，易于复用，易于拓展。**因为面向对象有封装，继承，多态的特性，所以可以设计出低耦合的系统，使系统更加灵活，更易于维护，但是性能比面向过程低。</div>
              </el-collapse-item>
              <el-collapse-item title="JVM，JRE，JDK的关系是什么？" name="2">
                <div>1,JDK（java Development Kit）的缩写，它是功能齐全的java SDK。它拥有JRE所拥有的一切，还有编译器（javac）和工具（javadoc和jdb）。它能创建和编译程序</div>
                <div>2,JRE是Java Runtime Envirment缩写，它是运行已编译Java程序所需的所有内容的集合，包括Java虚拟机（JVM）,java类库，java命令和其他的一些基础构件。但是，它不能用于创建新程序。</div>
                <div>3,JDK包含JRE，JRE包含JVM</div>
              </el-collapse-item>
              <el-collapse-item title="final  finally，finalize的区别？" name="3">
                <div>1,final用于修饰变量，方法和类。</div>
                <div>final变量：被修饰的变量不可变，不可变分为引用不可变和对象不可变，final指的是引用不可变，final修饰的变量必须初始化，通常称被修饰的变量为常量</div>
                <div>final方法：被修饰的方法不允许任何子类重写，子类可以使用该方法</div>
                <div>final类：被修饰的类不能被继承，所有方法不能被重写</div>
                <div>2,finally作为异常处理的一部分，它只能在try/catch语句中，并且附带一个语句块表示这段语句**最终一定被执行**（无论是否抛出异常），经常被用在需要释放资源的情况下，System.exit（0）可以阻断finally执行。</div>
                <div>3,finalize是在java.lang.Object里定义的方法，也就是说每一个对象都有这么个方法，这个方法在gc启动，该对象被会回收时被调用。</div>
                <div>4,一个对象的finalize方法只会被调用一次，finalize被调用不一定会立即回收该对象，所以有可能调用finalize后，该对象又不需要被回收了，然后到了真正要被回收的时候，因为前面调用过一次，所以不会在调用finalize了，进而产生问题，因此不推荐使用finalize方法。</div>
              </el-collapse-item>
              <el-collapse-item title="面向对象的三大特性" name="4">
                <div>1,封装，封装最好理解了，封装是面向对象的特征之一，是对象和类概念的主要特征。封装，也就是把客观事物封装成抽象的类，并且类可以把自己的数据和方法只让自己信任的类和对象进行操作，对不可信的进行信息隐藏。</div>
                <div>2,继承，继承是指这样一种能力，它可以使用现有类的所有功能，并在无需重新编译原来的类的情况下对这些功能进行拓展。通过继承创建的新类被称为“子类”或“派生类”，被继承的类称为基类或者父类，超类。</div>
                <div>3,继承，继承是指这样一种能力，它可以使用现有类的所有功能，并在无需重新编译原来的类的情况下对这些功能进行拓展。通过继承创建的新类被称为“子类”或“派生类”，被继承的类称为基类或者父类，超类。</div>
              </el-collapse-item>
              <el-collapse-item title="抽象类和接口的区别是什么？" name="5">
                <div>
                  语法层面上的区别
                  <p>抽象类提供成员方法的实现细节，而接口中只能存在public abstract方法</p>
                  <p>抽象类中成员变量可以是各种类型的，而接口只能是public static final</p>
                  <p>接口中不能存在静态代码块，以及静态方法，而抽象类可以有静态代码块和静态方法</p>
                  <p>一个类只能继承一个抽象类，但却可以实现多个接口</p>
                </div>
                <div>
                  设计层面的区别
                  <p>抽象类是对一个事物的抽象，即对类抽象，而接口是对行为的抽象，抽象类是对整个类进行抽象，包括属性，行为，但是接口却是对局部（行为）进行抽象</p>
                  <p>设计层面不同，抽象类作为很多子类的父类，它是一种模板式设计，而接口是一种行为规范，它是一种辐射式设计</p>
                </div>
              </el-collapse-item>
              <el-collapse-item title="Spring简介" name="6">
                <div>1,Spring框架由Rod Johnson开发，2004年发布了Spring框架的第一版。Spring是一个从实际开发中抽取出来的框架，因此它完成了大量开发中的通用步骤，留给开发者的仅仅是与特定应用相关的部分，从而大大提高了企业应用的开发效率。</div>
                <div>2,Spring总结起来优点如下：

                  <p>低侵入式设计，代码的污染极低。</p>
                  <p>独立于各种应用服务器，基于Spring框架的应用，可以真正实现Write Once，Run Anywhere的承诺。</p>
                  <p>Spring的IoC容器降低了业务对象替换的复杂性，提高了组件之间的解耦。</p>
                  <p>Spring的AOP支持允许将一些通用任务如安全、事务、日志等进行集中式管理，从而提供了更好的复用。</p>
                  <p>Spring的ORM和DAO提供了与第三方持久层框架的良好整合，并简化了底层的数据库访问。</p>
                  <p>Spring的高度开放性，并不强制应用完全依赖于Spring，开发者可自由选用Spring框架的部分或全部。</p>
                </div>
              </el-collapse-item>
              <el-collapse-item title="Redis 简介" name="7">
                <div>1,Redis 是完全开源的，遵守 BSD 协议，是一个高性能的 key-value 数据库。</div>
                <div>2,Redis 与其他 key - value 缓存产品有以下三个特点：

                  <p>Redis支持数据的持久化，可以将内存中的数据保存在磁盘中，重启的时候可以再次加载进行使用。</p>
                  <p>Redis不仅仅支持简单的key-value类型的数据，同时还提供list，set，zset，hash等数据结构的存储。</p>
                  <p>Redis支持数据的备份，即master-slave模式的数据备份。</p>
                </div>
              </el-collapse-item>
            </el-collapse>
          </div>
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
    </el-col>
  </el-row>
</template>

<script>
import la from "@/components/Leader";
import user from "../../components/UserLeader"
export default {
  name: "discuss-java",
  components: {
    la,
    user,
  },
  data(){
    return {
      comments: [{}],
      activeNames: ['1']
    }
  },
  created() {
    this.search()
  },
  methods :{
    search: async function() {
      const _this = this;
      this.$http.get("/comment")
        .then(function(res) {
          // for (let i in res.data.data.content){
          //   _this.comments.push(res.data.data[i])
          // }
          _this.comments = res.data.data;
          //_this.pagination.total = res.data.total
        }.bind(this))
        .catch(err =>{
          console.log("请求错误");
        });
    },
    handleChange(val) {
      console.log(val);
    }
  }

};
</script>
<style scoped>
.mlogo {
  height: 40px;
  margin-top: 18px;
}
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  width: 480px;
}
</style>
