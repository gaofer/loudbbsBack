论坛项目后台
==
这是我[另一个项目](https://github.com/gaofer/loudbbs)需要用到的后端代码，代码需要的sql文件已经放在 resources 文件夹下了，需要的话可以转储作为参考。


## 上手指南
即克隆即用，需要配置在 application.properties 文件中的数据库相关：地址、密码等。

## 所用框架
SpringBoot

## 相关工具
+ Druid
+ Lombok
+ MyBatis
+ MyBatis Plus
+ MySQL connector
+ MyBatis Plus Generator

## 项目相关说明
### 写在最前面 
这个项目一开始就打算用 MyBatis 做，然后之前觉得MyBatis Plus 的自动生成相关代码相当节省时间，所以就用自动生成生成了一些相关代码，不过生成时模块名又输入了一遍loudbbs 所以就会发现这个项目文件包有一点奇怪。  
数据库中没有做旗帜（flag）来标志是否删除，所有的删除操作是真真正正的删除！所以删除时请三思。  
先写到这，写后边东西去了，后边再想到什么再接着写。  

### 接口相关说明
接口大概分为四类：用户、话题、评论、类别。在访问接口时应对应地址、端口号等信息。
#### 用户
> t-users/login
>> get 方式  
>> 用途：用户登录  
>> 参数：String username, String password  
>> 返回：Json对象，如果成功，返回成功登录的用户对象和信息“登录成功”。  
>> 示例：_因为篇幅有限，只写一个示例，其他的大同小异，一般都是返回 Json 对象，若有不同，后面会具体说明。_
>> ```
>> //  请求地址
>> http://localhost:8080/loudbbs/t-users/login?username=zhangs&password=1234 
>>```
>>
>>```json
>> /* 返回*/
>>{
>>    "msg": "登陆成功",
>>    "code": 200,
>>    "data": {
>>        "uid": 26,
>>        "username": "zhangs",
>>        "password": "1234",
>>        "gender": null,
>>        "birthday": null,
>>        "avatar": null,
>>        "email": null,
>>        "phone": null,
>>        "access": "admin"
>>    }
>> }
>> ``` 
>> 
>  t-users/countusername
>> get 方式  
>> 用途：查询是否有用户名相同  
>> 参数：String username  
>> 返回：Json 对象，如果有重名，则返回成功  
>>
> t-users/  
>> get 方式  
>> 用途：查询所有用户  
>> 返回：所有用户对象  
>> 
> t-users/reg
>> post 方式  
>> 用途：注册新用户  
>> 参数：tuser 对象  
>> 返回：新注册的用户
>> 
> t-users/update
>> post 方式  
>> 用途：提升用户权限，将用户由普通用户提升为管理员  
>> 参数：tuser 对象  
>> 返回：null，成功参数返回200，失败返回400  
#### 类别
> category/
>> get 方式  
>> 用途：查询所有类别  
>> 
> category/
>> post 方式  
>> 用途：新建新类别  
>> 参数：tCategory 对象  
>> 返回：null，成功返回状态码200，失败返回400
>> 
> category/update
>> post 方式  
>> 用途：更改类别名  
>> 参数：tCategory 对象  
>> 返回： null，成功返回状态码200，失败返回400
>> 
> category/{cid}
>> delete 方式  
>> 用途：删除类别  
>> 参数：需要删除类别的id  
>> 返回： null，成功返回状态码200，失败返回400
#### 话题
> topic/
>> get 方式  
>> 用途：获取所有的话题  
>> 返回：Json对象，数据里是所有的话题对象，状态码成功200，失败400
>> 
> topic/addtopic
>>  post 方式  
>>  用途：新建话题  
>>  参数：topic 对象  
>>  返回： null，成功返回状态码200，失败返回400
>>  
> topic/update
>>  post 方式  
>>  用途：修改、更新话题  
>>  参数：topic 对象  
>>  返回： null，成功返回状态码200，失败返回400
>> 
>  topic/topicdetal/{tid}
>>  get 方式  
>>  用途：获取话题详细的信息    
>>  参数：topic 话题 id  
>>  返回： topicVOList，成功返回状态码200，失败返回400
>>  
> topic/{cid}
>> delete 方式  
>> 用途：根据删除话题的ID删除话题  
>> 参数：需要删除类别的id  
>> 返回： null，成功返回状态码200，失败返回400
#### 评论
> common/{tid}
>> get 方式  
>> 用途：根据tid获取所有关于该话题的评论  
>> 参数：tid  
>> 返回：Json对象，数据里是所有的评论对象，状态码成功200，失败400。如果没有评论，状态码还是200，msg内是"还没有人评论过，快来抢沙发吧！"
>> 
> common/
>> post 方式  
>> 用途：发表评论  
>> 参数：common 对象  
>> 返回： null，成功返回状态码200，失败返回400
## 作者
Gaofer Chou. 大概是个自恋狂。