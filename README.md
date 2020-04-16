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
* 新增商品 / 修改商品
```
POST: /dish/management
PUT: /dish/management
{
  {
      "categoryType": "appitizer"
      "productDescription" : "巨大的煎饼果子,保证你吃饱!"
      "productImage": "http://baidu.com/jianbingguozi/1.png"
      "productName": "煎饼果子"
      "productOwnerId": "youareremovedfromthegroup"
      "productPrice" : 5.98
      "productStock": 10
  }
}

{
    "status": "success",
    "data": [
        {
          "categoryType": "appitizer"
          "productDescription" : "巨大的煎饼果子,保证你吃饱!"
          "productImage": "http://baidu.com/jianbingguozi/1.png"
          "productName": "煎饼果子"
          "productOwnerId": "youareremovedfromthegroup"
          "productPrice" : 5.98
          "productStock": 10
        }
    ]
}
```
* 删除商品
```
DELETE: /dish/management
{
  {
       "productId" : 1
  }
}

{
    "status": "success",
    "data": [
        {
          "productName": "煎饼果子"
          "productOwnerId": "youareremovedfromthegroup"
        }
    ]
}
```
* 本人全部商品
```
GET: /dish
{
  {
      "productOwnerId": "youareremovedfromthegroup"
  }
}


{
    "status": "success",
    "data": [
        {
          "productId" : 1
          "categoryType": "appitizer"
          "productDescription" : "巨大的煎饼果子,保证你吃饱!"
          "productImage": "http://baidu.com/jianbingguozi/1.png"
          "productName": "煎饼果子"
          "productOwnerId": "youareremovedfromthegroup"
          "productPrice" : 5.98
          "productStock": 10
        },
        {
          "productId" : 2
          "categoryType": "mainDish"
          "productDescription" : "正宗武汉热干面"
          "productImage": "http://baidu.com/reganmian/1.png"
          "productName": "热干面"
          "productOwnerId": "youareremovedfromthegroup"
          "productPrice" : 4.99
          "productStock": 5
        }
    ]
}
```

* 库存管理
```
POST: /dish/repositoryManagement

  {
      "productName": "煎饼果子"
      "productOwnerId": "youareremovedfromthegroup"
      "productStock": 8
  }


{
    "status": "success",
    "data": [
        {
          "productName": "煎饼果子"
          "productOwnerId": "youareremovedfromthegroup"
          "productStock": 8
        }
    ]
}

```

#### 买家
* 查看所有商品   
```
GET:  /dish/all
 -- no body  

{
    "status": "success",
    "data": [
        {
          "categoryType": "appitizer"
          "productDescription" : "巨大的煎饼果子,保证你吃饱!"
          "productImage": "http://baidu.com/jianbingguozi/1.png"
          "productName": "煎饼果子"
          "productOwnerId": "youareremovedfromthegroup"
          "productPrice" : 5.98
          "productStock": 10
        },
        {
          "categoryType": "mainDish"
          "productDescription" : "正宗武汉热干面"
          "productImage": "http://baidu.com/reganmian/1.png"
          "productName": "热干面"
          "productOwnerId": "youareremovedfromthegroup"
          "productPrice" : 4.99
          "productStock": 5
        }
    ]
}
```

### 订单模块
* 结账下单
```
POST: transaction/
{
    "buyerId" : "asdfsadffas"
    "buyerAddress" : "1322421 rue adsfljk ,QC"
    "buyerPhone" : "5145424356"
    "orderItems" : [
        {
            "productId" : 1
            "quantity" : 1
        },
        {
            "productId" : 2
            "quantity" : 2
        }
    ]
}

{
    "status": "success",
    "data": [
        {
          "orderId" : 1
        }
    ]
}
```

* 提示新订单
```
待定 

```

* 接单 / 完成
```
POST: orderStatus/
PUT: orderStatus/
{
    "orderId" : 1,
    "orderStatus" : "processing" / "complete"

}

{
    "status" : "success",
    "data" : [
         {
            "orderId" : 1
            "orderStatus" : "processing" / "complete"
          }
    ]
}

```

