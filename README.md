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

用户注册：
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
```

