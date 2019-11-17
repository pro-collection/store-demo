## 设计相关数据库

```
选题9 企业产品仓库基本信息管理系统 
【实践内容】
建立一个企业产品仓库基本信息管理系统，编写应用程序完成系统开发。
 建立基本表：
1.客户基本信息表：客户编号、客户姓名、客户类型、联系人、联系电话、通信地址、备注；
2.仓库基本信息表：仓库编号、仓库名称、仓库说明；
3.产品基本信息表：产品编号、产品名称、产品规格、参考价格、数量上限、数量下限等；
4.用户基本信息表：用户编号、用户姓名、密码、权限、备注。 
【实践要求】
系统应包括以下主要功能：
（1）客户基本信息管理：客户基本信息添加、修改、查询、删除；
（2）仓库基本信息管理：仓库基本信息添加、修改、查询、删除； 
（3）产品基本信息管理：产品基本信息添加、修改、查询、删除； 
（4）用户管理：添加用户、权限修改、删除系统用户。
```

修改 `application.config.yml` --> `application.yml` 参数改为自己数据库的参数即可

```sql
create database if not exists store
  character set utf8;

use store;

create table if not exists client (
  id           int(10) primary key            not null auto_increment,
  name         varchar(20)                    not null,
  type         enum ('1', '2', '3', '4', '5') not null default '5',
  contacts     varchar(20)                    not null,
  concat_phone int(13)                        not null,
  address      varchar(200),
  mark         varchar(200)
)
  default charset = utf8;

create table if not exists store_info (
  id        int(10) primary key not null auto_increment,
  name      varchar(20)         not null,
  `declare` varchar(200)        not null
)
  default charset = utf8;

create table if not exists product (
  id            int(10) primary key not null auto_increment,
  name          varchar(20)         not null,
  specification varchar(20)         not null,
  price         double(20, 2)       not null,
  upper_limit   int(10)             not null default 1,
  lower_limit   int(10)             not null default 0
)
  default charset = utf8;

alter table product add url LONG;

create table if not exists user (
  id          int(10) primary key  not null auto_increment,
  name        varchar(20)          not null,
  password    varchar(20)          not null,
  permissions enum ('1', '2', '3') not null default '3'
  comment '限制 - 1：超级管理员  2：普通管理员  3：游客',
  mark        varchar(200)
)
  default charset = utf8;
```

### 接口：

#### 用户相关
```
post: /api/user/create
params: {name: string, password: string, permissions: number, mark: string}
备注： permissions - 权限， 范围为 1-3


post: /api/user/login
params: {name: string, password: string}


get: /api/user/logout
params: 无


post: /api/user/get - 查询用户信息
params: {name: string, password: string}


post: /api/user/update - 更新用户
params: {name: string, password: string, permissions: number, mark: string}


post: /api/user/delete - 删除用户
params: {id: number }
```

#### 产品相关
这里的接口需要登录才能调用
```
post: /api/product/insert  -  新建商品
parmas: {name: string, specification: string, price: number, upperLimit: number, lowerLimit: number, url: string}


get: /api/product/list  - 查看列表
params: 无


post: /api/product/remove  - 删除商品
params: {id: int}


```
