create database PrimeSneaker_OK
go

use PrimeSneaker_OK
go

create table Brand
(
	brand_id int identity(1,1) primary key,
	brand_name nvarchar(20),
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int,
	deleted bit default 1
)
go

create table Category
(
	category_id int identity(1,1) primary key,
	category_name nvarchar(50),
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int,
	deleted bit default 1
)
go

create table Size
(
	size_id int identity(1,1) primary key,
	size_number float,
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int,
	deleted bit default 1,
	check (size_number > 0)
)
go

create table Color
(
	color_id int identity(1,1) primary key,
	color_name nvarchar(20),
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int,
	deleted bit default 1
)
go

create table Sole
(
	sole_id int identity(1,1) primary key,
	sole_name nvarchar(50),
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int,
	deleted bit default 1
)
go

create table Material
(
	material_id int identity(1,1) primary key,
	material_name nvarchar(50),
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int,
	deleted bit default 1
)
go

create table Voucher
(
	voucher_id int identity(1,1) primary key,
	voucher_code varchar(10) unique,
	voucher_name nvarchar(100),
	discount_rate float check(discount_rate >= 0 and discount_rate <= 100),
	discount_amount money check(discount_amount >= 0),
	--  max_discout lưu số tiền hoặc %  tối đa mà 1 voucher có thể giảm giá cho đơn hàng khi sử dụng
	max_discount float check(max_discount >= 0),
	min_order_value money check(min_order_value >= 0),
	quantity int check(quantity >= 0),
	[start_date] date,
	end_date date,
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int,
	deleted bit default 1
)
go

create table [Role]
(
	role_id int identity(1,1) primary key,
	role_name nvarchar(50)
)
go

create table [User]
(
	[user_id] int identity(1,1) primary key,
	role_id int,
	user_code varchar(10) unique,
	full_name nvarchar(60),
	gender bit,
	date_of_birth date check(date_of_birth <= getdate()),
	phone_number varchar(15),
	[address] nvarchar(150),
	email varchar(100),
	id_card_number varchar(15),
	account_name varchar(30),
	[password] varchar(20),
	[status] nvarchar(50),
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int,
	deleted bit default 1
)
go

create table Customer
(
	customer_id int identity(1,1) primary key,
	full_name nvarchar(60),
	gender bit,
	date_of_birth date check(date_of_birth <= getdate()),
	[address] nvarchar(150),
	phone_number varchar(15),
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int
)
go

create table Sneaker
(
	sneaker_id int identity(1,1) primary key,
	brand_id int,
	category_id int,
	sole_id int,
	material_id int,
	sneaker_name nvarchar(100),
	[status] nvarchar(150),
	[description] nvarchar(200),
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int
)
go

create table SneakerDetail
(
	sneaker_detail_id int identity(1,1) primary key,
	sneaker_id int,
	size_id int,
	color_id int,
	sneaker_detail_code varchar(10) unique,
	gender nvarchar(20),
	price money check(price > 0),
	quantity int check(quantity > 0),
	[status] nvarchar(50),
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int
)
go

create table [Image]
(
	image_id int identity(1,1) primary key,
	sneaker_detail_id int,
	image_name nvarchar(50),
	image_url varchar(100),
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int,
	deleted bit default 1
)
go

create table [Order]
(
	order_id int identity(1,1) primary key,
	[user_id] int,
	customer_id int,
	voucher_id int,
	payment_method nvarchar(40),
	order_qr_code varchar(50),
	total_cost money check(total_cost >= 0),
	received_cash money check(received_cash >= 0),
	[change] money check([change] >= 0),
	[status] nvarchar(50),
	note nvarchar(255),
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int
)
go

create table OrderDetail
(
	sneaker_detail_id int not null,
	order_id int not null,
	quantity int check(quantity >= 0),
	price money check(price > 0),
	total_cost money check(total_cost > 0),
	created_at date default getdate(),
	updated_at date default getdate(),
	created_by int,
	updated_by int,
	primary key(sneaker_detail_id, order_id)
)
go

alter table [Image] add foreign key (sneaker_detail_id) references SneakerDetail (sneaker_detail_id)

alter table SneakerDetail add foreign key (sneaker_id) references Sneaker (sneaker_id)
alter table SneakerDetail add foreign key (size_id) references Size (size_id)
alter table SneakerDetail add foreign key (color_id) references Color (color_id)

alter table Sneaker add foreign key (brand_id) references Brand (brand_id)
alter table Sneaker add foreign key (category_id) references Category (category_id)
alter table Sneaker add foreign key (sole_id) references Sole (sole_id)
alter table Sneaker add foreign key (material_id) references Material (material_id)

alter table OrderDetail add foreign key (sneaker_detail_id) references SneakerDetail (sneaker_detail_id)
alter table OrderDetail add foreign key (order_id) references [Order] (order_id)

alter table [Order] add foreign key ([user_id]) references [User] ([user_id])
alter table [Order] add foreign key (customer_id) references Customer (customer_id)
alter table [Order] add foreign key (voucher_id) references Voucher (voucher_id)

alter table [User] add foreign key (role_id) references [Role] (role_id)

--alter table SneakerDetail add foreign key (collar_id) references Collar (collar_id)
--alter table SneakerDetail add foreign key (brand_id) references Brand (brand_id)
--alter table SneakerDetail add foreign key (category_id) references Category (category_id)
--alter table SneakerDetail add foreign key (sole_id) references Sole (sole_id)
--alter table SneakerDetail add foreign key (material_id) references Material (material_id)

--alter table OrderDetail add foreign key (exchange_id) references Exchange (exchange_id)

--alter table Exchange add foreign key (order_id) references [Order] (order_id)
--alter table Exchange add foreign key (sneaker_detail_id) references SneakerDetail (sneaker_detail_id)

drop table OrderDetail
drop table SneakerDetail
drop table Sneaker
drop table [Image]
--drop table Brand
--drop table Category
--drop table Color
--drop table Customer
--drop table Exchange
--drop table Material
--drop table [Order]
--drop table PaymentMethod
--drop table [Role]
--drop table [User]
--drop table Size
--drop table Sole
--drop table Voucher




--Nhập dữ liệu bảng Brand
insert into Brand(brand_name)
values('Nike'), ('Adidas'), ('Li-ning'), ('Converse'), ('MLB'), ('Fila'), ('New Balance'), ('Jordan'), ('Puma'), ('VANS'), ('Reebok')

--Nhập dữ liệu bảng Category
insert into Category(category_name)
values (N'Giày bóng rổ'), (N'Giày chạy'), (N'Giày tập gym'), (N'Giày golf')
insert into Category(category_name)
values (N'Giày casual')

--Nhập dữ liệu bảng Size
insert into Size(size_number)
values (34),(35),(36),(37),(38),(39),(40),(41),(42),(43),(44),(44.5),(45),(46),(47),(47.5)

--Nhập dữ liệu bảng Color
insert into Color(color_name)
values (N'Trắng'), (N'Nâu'), (N'Xanh'), (N'Xám'), (N'Vàng'), (N'Đen'), (N'Lục'), (N'Hồng'), (N'Cam')

--Nhập dữ liệu bảng Sole
insert into Sole(sole_name)
values(N'Đế cao su'), (N'Đế EVA'), (N'Đế PU'), (N'Đế da'), (N'Đế PVC'), (N'Đế TPR')

--Nhập dữ liệu bảng Material
insert into Material(material_name)
values(N'Da'), (N'Da Suede'), (N'Da Nubuck'), (N'Vải canvas'), (N'Vải Denim'), (N'Vật liệu tổng hợp')

-- Nhập dữ liệu Role
insert into [Role](role_name)
values (N'Quản lý'),
(N'Nhân viên')

--Nhập dữ liệu User
insert into [User](role_id, user_code, full_name, gender, date_of_birth, phone_number, [address], email, id_card_number, account_name, [password], [status])
values (1, 'NV001', N'Bùi Minh Hiếu', 1, '1997-09-11', '0975416197', N'Đan Phượng - Hà Nội', 'hieubm@gmail.com', '0010003223', 'hieu119', 'hieu1997', N'Đang làm việc'),
(2, 'NV002', N'Phạm Thị Lan Anh', 0, '2003-05-22', '0933678422', N'Đan Phượng - Thái Bình', 'lananhpt@gmail.com','001023254', 'lananh2003', 'lananh2003', N'Đang làm việc'),
(2, 'NV003', N'Phạm Thị Hường', 0, '1997-08-27', '0984783253', N'Sóc Sơn - Hà Nội', 'huongpt@gmail.com','001043432', 'huong2708', 'huong1997', N'Đã nghỉ việc'),
(2, 'NV004', N'Trần Thị Ánh Quỳnh', 0, '2002-3-22', '0830003212', N'Phủ Lý - Hà Nam', 'quynhtta@gmail.com','0034325343', 'quynh2002', 'quynh123', N'Đang làm việc'),
(2, 'NV005', N'Phan Quang Hảo', 1, '1998-04-11', '0975411998', N'Lục Nam - Bắc Giang', 'haopq@gmail.com','0014343332', 'hao222', 'haove1998', N'Đang làm việc'),
(2, 'NV006', N'Hoàng Văn Thảnh', 1, '2000-02-19', '0333567843', N'Vĩnh Yên Vĩnh Phúc', 'thanhhv@gmail.com','0010004334', 'thanh2000', 'thanh123', N'Đang làm việc'),
(1, 'NV007', N'Nguyễn Minh Hiền', 0, '1991-03-11', '0973234323', N'Hoàng Mai - Hà Nội', 'hienmn@gmail.com','0010665677', 'hien1991', 'hien12345', N'Đã nghỉ việc'),
(2, 'NV008', N'Hoàng Kim Bảo', 1, '1999-09-21', '0975323447', N'Chí Linh - Hải Dương', 'baokh@gmail.com','0017533787', 'bao2222', 'baohq2222', N'Đã nghỉ việc')
go

--Nhập dữ liệu Customer
insert into Customer(full_name, gender, date_of_birth, [address], phone_number)
values (N'Nguyễn Văn Hiếu', 1, '1990-05-10', N'123 Trịnh Văn Bô, Nam Từ Liêm, Hà Nội', '0843456789'),
(N'Nguyễn Minh Hoàng', 1, '1999-02-13', N'456 Hoàng Diệu, Quận Ba Đình, Hà Nội', '0987654321'),
(N'Trần Thị Hồng', 0, '2004-03-15', N'789 Thái Hà, Quận Đống Đa, Hà Nội', '0369874512'),
(N'Chu Việt Linh', 1, '1992-05-30', N'111 Lý Thường Kiệt, Quận Hoàn Kiếm, Hà Nội', '0765432198'),
(N'Nguyễn Văn Tài', 1, '2003-10-10', N'222 Phố Huế, Quận Hai Bà Trưng, Hà Nội', '0912345678'),
(N'Chu Kim Ngân', 0, '1991-08-14', N'333 Trần Phú, Quận Hoàng Mai, Hà Nội', '0567891234'),
(N'Nguyễn Phi Nhung', 0, '2007-01-11', N'444 Kim Mã, Quận Ba Đình, Hà Nội', '0876543210'),
(N'Tạ Tuấn Hưng', 1, '1985-07-29', N'555 Phan Chu Trinh, Quận Hoàn Kiếm, Hà Nội', '0999888777'),
(N'Nguyễn Tiến Hưng', 1, '2001-05-20', N'666 Trần Quý Cáp, Quận Cầu Giấy, Hà Nội', '0333555777'),
(N'Chu Bảo Ngọc', 0, '1993-01-27', N'177 Kim Ngưu, Quận Hai Bà Trưng, Hà Nội', '0555222888'),
(N'Trần Phương Nhi', 0, '1998-09-11', N'Số 10 Nguyễn Văn Linh, Hải Phòng', '0932587412'),
(N'Nguyễn Văn Phương', 1, '1996-05-22', N'20 Trần Hưng Đạo, Hà Giang', '0918273645'),
(N'Bùi Huy Hoàng', 1, '2003-02-26', N'30 Lê Lai, Thái Bình', '0354172896')

--Nhập dữ liệu bảng Voucher
insert into Voucher (voucher_code, voucher_name, discount_rate, discount_amount, max_discount, min_order_value, quantity, [start_date], end_date)
values ('VOUCHER1', N'Khuyến mãi hè', 0.1, NULL, 100000, 500000, 20, '2024-06-01', '2024-12-31'),
('VOUCHER2', N'Khuyến mãi 30/4 - 1/5', 0.15, NULL, 150000, 700000, 20, '2024-02-01', '2024-11-30'),
('VOUCHER3', N'Khuyến mãi ngày Phụ nữ 20/10', NULL, 50000, 200000, 300000, 20, '2024-05-01', '2024-10-31'),
('VOUCHER4', N'Khuyến mãi Quốc khánh 2/9', 0.2, NULL, 250000, 800000, 20, '2024-04-01', '2024-09-30'),
('VOUCHER5', N'Khuyến mãi Black Friday', NULL, 70000, 300000, 400000, 20, '2024-06-01', '2024-08-31'),
('VOUCHER6', N'Khuyến mãi đầu Xuân', 0.25, NULL, 300000, 900000, 20, '2024-06-01', '2024-07-31'),
('VOUCHER7', N'Khuyến mãi sinh nhật shop', NULL, 100000, 350000, 600000, 20, '2024-07-01', '2024-06-30'),
('VOUCHER8', N'Khuyến mãi sinh nhật khách hàng', 0.3, NULL, 400000, 950000, 20, '2024-08-01', '2024-05-31'),
('VOUCHER9', N'Khuyến mãi valentine', NULL, 120000, 200000, 700000, 20, '2024-09-01', '2024-04-30'),
('VOUCHER10', N'Khuyến mãi chăm sóc khách hàng', 0.35, NULL, 500000, 1000000, 20, '2024-01-01', '2024-03-31');

insert into Voucher (voucher_code, voucher_name, discount_rate, discount_amount, max_discount, min_order_value, quantity, [start_date], end_date)
values ('VOUCHER0', N'Không', 0, NULL, 0, 0, 0,'2022-12-31' , '2100-12-31')

--Nhập dữ liệu bảng Sneaker
insert into Sneaker(brand_id, category_id, sole_id, material_id, sneaker_name,[status], [description])
values
--#den, da, nike
(1,1,1,2,N'Giày Nike Air Jordan 4', N'Đang bán', N'Phiên bản đặc biệt của dòng sản phẩm Air Jordan, được thiết kế để tôn vinh và tái hiện lại phiên bản kinh điển “Bred” (Black and Red) của dòng Air Jordan 4'),

--xám, đế cao su, nike
(1,1,1,3,N'Nike Jordan 1 Dior', N'Đang bán', N'Được giới thiệu tại triển lãm “Paris 3020.” của nghệ sĩ đương đại Daniel Arsham'),

--Đen, da, vải, nike
(1,2,1,5,N'Nike Pegasus 40', N'Chưa mở bán', N'Giày chuyên chạy bộ thiết kế đẹp mắt'),

--trắng, da, nike
(1,3,5,3,N'Nike Air Force 1', N'Chưa mở bán', N'Là một trong những form dáng giày thể thao được giới trẻ quan tâm và yêu thích'),

--trắng, da, adidas
(2,1,3,1,N'Adidas Superstar', N'Đang bán', N'Hiện đã có sẵn tại Sneaker Daily Shop'),

--da suede, trắng, đen, nâu, đế EVA, adidas
(2,5,2,2,N'Adidas Samba', N'Đang bán', N'Giày thể thao cổ điển được thiết kế dành cho phong cách thường ngày'),

--Xanh, adidas, vải
(2,2,1,4,N'Adidas Ultraboost', N'Đang bán', N'Đã được bày bán trên Sneaker Daily Shop'),

-- da, adidas, 5900000
(2,2,1,5,N'Giày adidas golf wide tour', N'Đang bán', N'Hiện đã có sẵn tại Sneaker Daily Shop'),

--trắng, cao su, converse, 2.200.000₫ -> 1.390.000₫
(4,5,1,5,N'Giày Converse Chuck 70', N'Đang bán', N' Là một trong những mẫu giày đang được nhiều bạn trẻ kiếm tìm hiện nay'),

--converse, trắng, đế cao su, 2.990.000₫ 1.490.000₫
(4,5,1,5,N'Giày Converse Chuck Taylor All Star', N'Đang bán', N'Hứa hẹn là một siêu phẩm mà bất cứ sneakerhead nào cũng mong muốn sở hữu trong tủ giày của mình'),

--lining, xanh, bóng rổ, 1.490.000₫
(3,1,3,2,N'Giày Li-Ning bóng rổ', N'Đang bán', N'Đôi giày chuyên dụng được thiết kế đặc biệt cho các vận động viên nam chơi bóng rổ'),

--lining, trắng, 2.380.000₫
(3,5,5,1,N'Giày Li-ning Common 70s', N'Đang bán', N'Phong cách thời trang, cá tính, trẻ trung, phù hợp cho đi học, đi làm, đi chơi, dạo phố'),

--lining, vàng, hồng, 2.580.000₫
(3,2,1,6,N'Giày chạy bộ Chitu 7', N'Đang bán', N'Năng động, trẻ trung, phù hợp cho chạy bộ'),

--fila, trắng, 1.490.000₫
(6,5,2,3,N'Giày Fila Ranger', N'Đang bán', N'Mức giá hấp dẫn, đừng bỏ lỡ cơ hội'),

--fila, trắng, 2.290.000₫
(6,4,3,2,N'Giày Fila Disruptor 2 Scotch', N'Đang bán', N'Là một phiên bản đặc biệt của dòng giày Fila Disruptor 2'),

--mlb, trắng, 2.790.000₫
(5,3,2,2,N'Giày MLB Chunky Liner', N'Đang bán', N'No description'),

--mlb, trắng, 1.500.000₫
(5,5,3,2,N'Giày MLB BigBall Chunky', N'Đang bán', N'Phong cách Chunky'),

--mlb, trắng, 3.390.000₫
(5,2,2,4,N'Giày MLB Chunky Runner SD', N'Đang bán', N'Tạo độ đàn hồi mang lại cảm giác cực kỳ thoải mái, nhẹ nhàng và dễ chịu'),

--newb, trắng-lục, 3.790.000₫
(7,5,3,4,N'Giày New Balance 550 ', N'Đang bán', N'Một thương hiệu thời trang và giày thể thao từ Mỹ'),

--newb, trắng, 2.590.000₫
(7,2,1,5,N'Giày New Balance Fresh Foam X 880v14', N'Đang bán', N'Một thương hiệu thời trang và giày thể thao từ Mỹ'),

--newb, xám, 1.690.000₫
(7,1,2,6,N'Giày New Balance Fresh Foam BB v2', N'Đang bán', N'Phiên bản thuộc dòng giày thể thao cổ điển của New Balance'),

--puma, 1.990.000₫, trắng
(9,1,2,4,N'Giày Puma Basket Heart Patent', N'Đang bán', N'Giày Puma'),

--puma, trắng, 1.980.000₫
(9,2,2,5,N'Giày Puma Velocity NITRO 3', N'Đang bán', N'No description'),

--puma, trắng-đen, 2.980.000₫
(9,4,3,2,N'Giày Puma Mayze', N'Đang bán', N'PUMA bắt tay với MTV để tạo ra một phiên bản RS-X mới'),

--puma, xanh, 2.090.000₫
(9,5,1,5,N'Giày Puma Suede Classic', N'Đang bán', N'Khả năng chống thấm nước trên cả tuyệt vời, độ bền màu, chất liệu êm ái'),

--reebok, đen, 1.790.000₫
(11,5,5,3,N'Giày Reebok Royal Pervader', N'Đang bán', N'No description'),

--reebok, trắng, 1.790.000₫
(11,2,5,2,N'Giày Reebok Floatride Energy 5', N'Đang bán', N'Phù hợp cho những người yêu thích phong cách thể thao và đang tìm kiếm một đôi giày thể thao năng động và trẻ trung'),

--vans, trắng, 2.290.000₫
(10,5,3,4,N'Giày Vans Old Skool', N'Đang bán', N'No description'),

--vans, trắng, 2.500.000₫
(10,5,2,5,N'Giày Vans checkerboard slip-on classic', N'Đang bán', N'No description'),

--vans, đen-lục, 1.690.000₫
(10,5,3,4,N'Giày Vans classic', N'Đang bán', N'No description')

--Nhập dữ liệu SneakerDetail
insert into SneakerDetail  (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (1, 2, 1, '2345522', 0, 1500000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (1, 4, 3, '2345530', 1, 1500000, 10, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (1, 7, 2, '2345531', 1, 1500000, 10, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (2, 6, 4, '2345532', 0, 2600000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (2, 8, 5, '2345533', 0, 2600000, 15, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (2, 7, 2, '2345534', 1, 2600000, 5, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (3, 6, 5, '23455305', 1, 2500000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (3, 1, 3, '2345535', 0, 2500000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (3, 6, 2, '2345536', 1, 2500000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (4, 9, 5, '2345537', 0, 1000000, 20, N'Đã ngừng bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (5, 11, 3, '2345538', 1, 1300000, 20, N'Đã ngừng bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (4, 2, 5, '2345539', 0, 1200000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (4, 3, 2, '2345540', 1, 1400000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (5, 5, 7, '23455301', 1, 1200000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (6, 4, 3, '23455302', 0, 1500000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (7, 2, 4, '23455303', 1, 1200000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (8, 5, 1, '23455304', 1, 2000000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (9, 2, 1, '234553054', 0, 1800000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (11, 8, 2, '23455306', 1, 1400000, 20, N'Đã ngừng bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (11, 7, 3, '23455307', 0, 1200000, 20, N'Đã ngừng bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (11, 9, 4, '23455308', 1, 1800000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (12, 12, 5, '23455309', 1, 1500000, 20, N'Đang bán')
insert into SneakerDetail (sneaker_id, size_id, color_id, sneaker_detail_code, gender, price, quantity, [status])
values (12, 4, 7, '2345541', 0, 1500000, 20, N'Đang bán')

-- Nhập dữ liệu Image
insert into [Image] (sneaker_detail_id, image_url)
values (1, 'anh1.jpg')
insert into [Image] (sneaker_detail_id, image_url)
values (2, 'anh2.jpg')
insert into [Image] (sneaker_detail_id, image_url)
values (3, 'anh3.jpg')
insert into [Image] (sneaker_detail_id, image_url)
values (4, 'anh4.jpg')
insert into [Image] (sneaker_detail_id, image_url)
values (5, 'anh5.jpg')
insert into [Image] (sneaker_detail_id, image_url)
values (6, 'anh6.jpg')
insert into [Image] (sneaker_detail_id, image_url)
values (7, 'anh7.jpg')
insert into [Image] (sneaker_detail_id, image_url)
values (8, 'anh8.jpg')
insert into [Image] (sneaker_detail_id, image_url)
values (9, 'anh9.jpg')
insert into [Image] (sneaker_detail_id, image_url)
values (10, 'anh10.jpg')

--Nhập dữ liệu Order
insert into [Order] ([user_id], customer_id, voucher_id, payment_method, order_qr_code, total_cost, received_cash, [change], [status], note)
values (2, 2, 1, N'Tiền mặt', '09366432', 1620000, 1620000, 0, N'Đã thanh toán', null)
insert into [Order] ([user_id], customer_id, voucher_id, payment_method,  order_qr_code, total_cost, received_cash, [change], [status], note)
values (3, 1, null, N'Tiền mặt', '09366433', 2000000, 2000000, 0, N'Đã thanh toán', null)
insert into [Order] ([user_id], customer_id, voucher_id, payment_method, order_qr_code, total_cost, received_cash, [change], [status], note)
values (2, 3, null, N'Chuyển khoản', '09366434', 1400000, 1500000, 100000, N'Đã thanh toán', null)
insert into [Order] ([user_id], customer_id, voucher_id, payment_method, order_qr_code, total_cost, received_cash, [change], [status], note)
values (3, 4, 4, N'Chuyển khoản', '09366435', 2600000, 26000000, 0, N'Đã thanh toán', null)
insert into [Order] ([user_id], customer_id, voucher_id, payment_method, order_qr_code, total_cost, received_cash, [change], [status], note)
values (4, 5, 4, N'Tiền mặt', '09366436', 1500000, 1500000, 0, N'Đã thanh toán', null)
insert into [Order] ([user_id], customer_id, voucher_id, payment_method, order_qr_code, total_cost, received_cash, [change], [status], note)
values (4, 6, null, N'Chuyển khoản', '09366427', 1200000, 1200000, 0, N'Đã thanh toán', null)
insert into [Order] ([user_id], customer_id, voucher_id, payment_method, order_qr_code, total_cost, received_cash, [change], [status], note)
values (5, 7, null, N'Tiền mặt', '09366437', 1800000, 2000000, 200000, N'Đã thanh toán', null)
insert into [Order] ([user_id], customer_id, voucher_id, payment_method, order_qr_code, total_cost, received_cash, [change], [status], note)
values (4, 8, 1, N'Tiền mặt', '09366438', 2600000, 2600000, 0, N'Đã thanh toán', null)
insert into [Order] ([user_id], customer_id, voucher_id, payment_method, order_qr_code, total_cost, received_cash, [change], [status], note)
values (3, 9, 4, N'Tiền mặt', '09366439', 1200000, 1200000, 0, N'Đã thanh toán', null)
insert into [Order] ([user_id], customer_id, voucher_id, payment_method, order_qr_code, total_cost, received_cash, [change], [status], note)
values (5, 10, null, N'Tiền mặt', '09366410', 1400000, 1500000, 50000, N'Đã thanh toán', null)
insert into [Order] ([user_id], customer_id, voucher_id, payment_method, order_qr_code, total_cost, received_cash, [change], [status], note)
values (6, 11, null, N'Chuyển khoản', '09366411', 1000000, 1000000, 0, N'Đã thanh toán', null)

-- Nhập dữ liệu Order Detail
insert into OrderDetail (sneaker_detail_id, order_id, quantity, price, total_cost)
values (18, 1, 1, 1800000, 1800000)
insert into OrderDetail (sneaker_detail_id, order_id, quantity, price, total_cost)
values (17, 2, 1, 2000000, 2000000)
insert into OrderDetail (sneaker_detail_id, order_id, quantity, price, total_cost)
values (13, 3, 1, 1400000, 1400000)
insert into OrderDetail (sneaker_detail_id, order_id, quantity, price, total_cost)
values (5, 4, 1, 2600000, 2600000)
insert into OrderDetail (sneaker_detail_id, order_id, quantity, price, total_cost)
values (15, 5, 1, 1500000, 1500000)
insert into OrderDetail (sneaker_detail_id, order_id, quantity, price, total_cost)
values (14, 6, 1, 1200000, 1200000)
insert into OrderDetail (sneaker_detail_id, order_id, quantity, price, total_cost)
values (21, 7, 1, 1800000, 1800000)
insert into OrderDetail (sneaker_detail_id, order_id, quantity, price, total_cost)
values (4, 8, 1, 2600000, 2600000)
insert into OrderDetail (sneaker_detail_id, order_id, quantity, price, total_cost)
values (16, 9, 1, 1200000, 1200000)
insert into OrderDetail (sneaker_detail_id, order_id, quantity, price, total_cost)
values (19, 10, 1, 1900000, 1900000)

-- Nhập dữ liệu Collar
--insert into Collar (type_collar)
--values (N'Cổ cao'),
--(N'Cổ cổ thấp'),
--(N'Cổ vừa')

select * from OrderDetail
select * from [Order]
select * from [Image]
select * from SneakerDetail
select * from Sneaker
select * from Brand
select * from Category
select * from Color
select * from Material
select * from Size
select * from Sole
select * from Customer
select * from [Role]
select * from [User]
select * from Voucher


select *
from OrderDetail
where order_id = 35

select sneaker_detail_id, sneaker_detail_code, sneaker_name, price, (quantity - 2) as quantity, category_name, brand_name, color_name, material_name,sole_name, size_number 
              from Sneaker s join Brand b on s.brand_id = b.brand_id
              join Category c on s.category_id = c.category_id
              join Sole so on s.sole_id = so.sole_id
              join Material m on s.material_id = m.material_id
              right join SneakerDetail sd on s.sneaker_id = sd.sneaker_id
              join Size si on sd.size_id = si.size_id
              join Color co on sd.color_id = co.color_id

			  select sneaker_detail_id, sneaker_detail_code,  price, (quantity - 2) as quantity, color_name, size_number 
			  from SneakerDetail
			  where sneaker_detail_code = 2345522
			  

			  select * from SneakerDetail