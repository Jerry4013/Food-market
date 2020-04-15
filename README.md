# Food-market

## 项目需求：

### 用户模块

* 用户注册
* 登陆
* 改密码
* 修改个人信息

### 商品模块

* 作为卖家，新增、修改、删除商品、查看本人的商品
* 所有用户都能查看所有在售的商品
* 加减库存

### 订单模块

* 加入购物车
* 结账下单

* 收藏

### 卖家订单

* 提示新订单
* 接单
* 完成订单

## API

### 用户模块
* 用户注册：
```
POST: /user/new   
{
  {
      "username": "youareremovedfromthegroup"
      "password": "ohoh",
      "name": "张三",
      "email": "abc@gmail.com",
      "address": "124124 sdfka, QC",
      "tel": "1234567"
  }
}

{
    "status": "success",
    "data": [
        {
            "userName": "youareremovedfromthegroup",
            "name": "张三",
            "email": "abc@gmail.com",
            "address": "124124 sdfka, QC",
            "tel": "1234567"
        }
    ]
}

```
* 登录:
```
POST: /user/login
{
  {
      "username": "youareremovedfromthegroup"
      "password": "ohoh",
    
  }
}

{
    "status": "success",
    "data": [
        {
            "name": "张三"
        }
    ]
}
```
* 改密码:
```
POST: /user/pwdchange
{
  {
      "username": "youareremovedfromthegroup"
      "password": "ohoh",
      "newpassword": "xoxo"
  }
}

{
    "status": "success",
    "data": [
        {
            "name": "张三"
        }
    ]
}
```
* 修改个人信息:
```
POST: /user/infochange
{
  {
      "username": "youareremovedfromthegroup"
      "name": "王五",
      "email": "vvv@gmail.com",
      "address": "124124 sdfka, QC",
      "tel": "1234567"
  }
}

{
    "status": "success",
    "data": [
        {
            "username": "youareremovedfromthegroup"
            "name": "王五",
            "email": "vvv@gmail.com",
            "address": "124124 sdfka, QC",
            "tel": "1234567"
        }
    ]
}

```
### 商品模块
* 作为卖家，新增、修改、删除商品、查看本人的商品
* 所有用户都能查看所有在售的商品
* 加减库存
#### 卖家
* 新增商品
```
POST: /dish/new
{
  {
      "username": "youareremovedfromthegroup"
      "productName": "煎饼果子"
      "categoryType": "appitizer"
      "price" : 5.98
      "productImage": "http://baidu.com/jianbingguozi/1.png"
      "productDescription" : "巨大的煎饼果子,保证你吃饱!"
  }
}

{
    "status": "success",
    "data": [
        {
            "name": "张三"
        }
    ]
}
```

