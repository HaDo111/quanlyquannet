USE [qlqn]
GO
/****** Object:  Table [dbo].[pc]    Script Date: 5/24/2022 6:10:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pc](
	[mamay] [nvarchar](50) NOT NULL,
	[tenmay] [nvarchar](50) NULL,
	[tenphong] [nvarchar](50) NULL,
	[main] [nvarchar](50) NULL,
	[bxl] [nvarchar](50) NULL,
	[carddh] [nvarchar](50) NULL,
	[ram] [int] NULL,
	[manhinh] [int] NULL,
	[ttmanhinh] [bit] NULL,
	[chuot] [bit] NULL,
	[banphim] [bit] NULL,
	[tainghe] [bit] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[phongmay]    Script Date: 5/24/2022 6:10:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phongmay](
	[maphong] [nvarchar](50) NOT NULL,
	[tenphong] [nvarchar](50) NULL,
	[slmay] [int] NULL,
	[tang] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[taikhoan]    Script Date: 5/24/2022 6:10:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[taikhoan](
	[tk] [nvarchar](50) NULL,
	[mk] [nvarchar](12) NULL
) ON [PRIMARY]

GO
INSERT [dbo].[pc] ([mamay], [tenmay], [tenphong], [main], [bxl], [carddh], [ram], [manhinh], [ttmanhinh], [chuot], [banphim], [tainghe]) VALUES (N'01', N'pc01', N'Phong Thuong', N'H16', N'Intel i5', N'vga 750ti 2GB', 6, 22, 1, 1, 1, 1)
INSERT [dbo].[pc] ([mamay], [tenmay], [tenphong], [main], [bxl], [carddh], [ram], [manhinh], [ttmanhinh], [chuot], [banphim], [tainghe]) VALUES (N'02', N'pc02', N'Phong Vip', N'H16', N'Intel i7', N'vga 1050ti 4GB', 8, 24, 1, 1, 1, 1)
INSERT [dbo].[pc] ([mamay], [tenmay], [tenphong], [main], [bxl], [carddh], [ram], [manhinh], [ttmanhinh], [chuot], [banphim], [tainghe]) VALUES (N'03', N'pc03', N'Phong Doi', N'H16', N'intle i5', N'vga 750ti 2GB', 6, 22, 1, 1, 1, 1)
INSERT [dbo].[pc] ([mamay], [tenmay], [tenphong], [main], [bxl], [carddh], [ram], [manhinh], [ttmanhinh], [chuot], [banphim], [tainghe]) VALUES (N'04', N'pc04', N'Phong Thi Dau', N'H16', N'intel i7', N'vga 1050ti 4GB', 8, 24, 1, 1, 1, 1)
INSERT [dbo].[pc] ([mamay], [tenmay], [tenphong], [main], [bxl], [carddh], [ram], [manhinh], [ttmanhinh], [chuot], [banphim], [tainghe]) VALUES (N'05', N'pc05', N'Phong Thuong', N'H16', N'Intel i5', N'vga 750ti 2GB', 6, 22, 0, 1, 0, 0)
INSERT [dbo].[pc] ([mamay], [tenmay], [tenphong], [main], [bxl], [carddh], [ram], [manhinh], [ttmanhinh], [chuot], [banphim], [tainghe]) VALUES (N'06', N'pc06', N'Phong Thuong', N'H16', N'Intel i5', N'vga 750ti 2GB', 6, 22, 0, 0, 0, 0)
INSERT [dbo].[pc] ([mamay], [tenmay], [tenphong], [main], [bxl], [carddh], [ram], [manhinh], [ttmanhinh], [chuot], [banphim], [tainghe]) VALUES (N'07', N'pc07', N'Phong Vip', N'H16', N'intel i7', N'vga 750ti 2GB', 8, 22, 1, 1, 1, 1)
INSERT [dbo].[pc] ([mamay], [tenmay], [tenphong], [main], [bxl], [carddh], [ram], [manhinh], [ttmanhinh], [chuot], [banphim], [tainghe]) VALUES (N'08', N'pc08', N'Phong Thi Dau', N'H16', N'intel i7', N'vga 1050ti 4GB', 8, 24, 0, 1, 1, 1)
INSERT [dbo].[pc] ([mamay], [tenmay], [tenphong], [main], [bxl], [carddh], [ram], [manhinh], [ttmanhinh], [chuot], [banphim], [tainghe]) VALUES (N'09', N'pc09', N'Phong Thuong', N'H16', N'Intel i5', N'vga 750ti 2GB', 6, 22, 0, 1, 1, 1)
INSERT [dbo].[pc] ([mamay], [tenmay], [tenphong], [main], [bxl], [carddh], [ram], [manhinh], [ttmanhinh], [chuot], [banphim], [tainghe]) VALUES (N'10', N'pc10', N'Phong Thuong', N'H16', N'Intel i5', N'vga 750ti 2GB', 6, 22, 1, 1, 1, 1)
INSERT [dbo].[pc] ([mamay], [tenmay], [tenphong], [main], [bxl], [carddh], [ram], [manhinh], [ttmanhinh], [chuot], [banphim], [tainghe]) VALUES (N'11', N'pc11', N'Phong Thuong', N'H16', N'Intel i5', N'vga 750ti 2GB', 6, 22, 1, 1, 1, 1)
INSERT [dbo].[pc] ([mamay], [tenmay], [tenphong], [main], [bxl], [carddh], [ram], [manhinh], [ttmanhinh], [chuot], [banphim], [tainghe]) VALUES (N'12', N'pc12', N'Phong Thuong', N'H16', N'Intel i5', N'vga 750ti 2GB', 6, 22, 1, 1, 1, 1)
INSERT [dbo].[pc] ([mamay], [tenmay], [tenphong], [main], [bxl], [carddh], [ram], [manhinh], [ttmanhinh], [chuot], [banphim], [tainghe]) VALUES (N'13', N'pc13', N'Phong Thuong', N'H16', N'Intel i5', N'vga 750ti 2GB', 6, 22, 1, 1, 1, 1)
INSERT [dbo].[phongmay] ([maphong], [tenphong], [slmay], [tang]) VALUES (N'01', N'Phong Thuong', 50, N'1')
INSERT [dbo].[phongmay] ([maphong], [tenphong], [slmay], [tang]) VALUES (N'02', N'Phong Vip', 30, N'2')
INSERT [dbo].[phongmay] ([maphong], [tenphong], [slmay], [tang]) VALUES (N'03', N'Phong Thi Dau', 10, N'1')
INSERT [dbo].[phongmay] ([maphong], [tenphong], [slmay], [tang]) VALUES (N'04', N'Phong Doi', 20, N'2')
INSERT [dbo].[taikhoan] ([tk], [mk]) VALUES (N'admin', N'123')
INSERT [dbo].[taikhoan] ([tk], [mk]) VALUES (N'a', N'222')
INSERT [dbo].[taikhoan] ([tk], [mk]) VALUES (N'ahihi', N'123')
INSERT [dbo].[taikhoan] ([tk], [mk]) VALUES (N'note155', N'155')
