USE [Product_Managerment]
GO
/****** Object:  Table [dbo].[FinancialPaperDetail]    Script Date: 1/10/2022 7:44:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FinancialPaperDetail](
	[KeyDetail] [uniqueidentifier] NOT NULL,
	[KeyFinace] [uniqueidentifier] NULL,
	[BARCODE] [nvarchar](200) NULL,
	[Quantily] [int] NULL,
	[Discount] [int] NULL,
	[Price] [float] NULL,
	[Date] [datetime] NULL,
	[No] [int] NULL,
	[Amount] [float] NULL,
 CONSTRAINT [PK_FinancialPaperDetail] PRIMARY KEY CLUSTERED 
(
	[KeyDetail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FinancialPaper]    Script Date: 1/10/2022 7:44:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FinancialPaper](
	[KeyFinance] [uniqueidentifier] NOT NULL,
	[NoFP] [nvarchar](50) NULL,
	[Category] [int] NULL,
	[Discount] [int] NULL,
	[Date] [datetime] NULL,
	[NoFP2] [nvarchar](50) NULL,
	[DAY2] [datetime] NULL,
	[Quantily] [int] NULL,
	[Sum] [float] NULL,
	[Note] [nvarchar](500) NULL,
	[IdCompany] [nvarchar](50) NULL,
	[IdDepartment] [nvarchar](50) NULL,
	[IdDepartment2] [nvarchar](50) NULL,
	[Status] [int] NULL,
	[CREATED_DATE] [datetime] NULL,
	[UPDATE_DATE] [datetime] NULL,
	[DELETE_DATE] [datetime] NULL,
 CONSTRAINT [PK_FinancialPaper] PRIMARY KEY CLUSTERED 
(
	[KeyFinance] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 1/10/2022 7:44:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[BARCODE] [nvarchar](100) NOT NULL,
	[NameProduct] [nvarchar](300) NULL,
	[NameAT] [nvarchar](200) NULL,
	[Unit] [nvarchar](100) NULL,
	[Price] [float] NULL,
	[IdSupplier] [nvarchar](50) NULL,
	[IdSource] [int] NULL,
	[IdGroupProduct] [int] NULL,
	[Note] [nvarchar](500) NULL,
	[CREATE_DATE] [datetime] NULL,
	[CREATE_BY] [int] NULL,
	[DISABLED] [bit] NULL,
	[Image] [nvarchar](500) NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[BARCODE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GroupProduct]    Script Date: 1/10/2022 7:44:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GroupProduct](
	[IdGroupProduct] [int] IDENTITY(1,1) NOT NULL,
	[NameGProduct] [nvarchar](300) NULL,
	[Note] [nvarchar](600) NULL,
	[DISABLED] [bit] NULL,
 CONSTRAINT [PK_GroupProduct] PRIMARY KEY CLUSTERED 
(
	[IdGroupProduct] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  UserDefinedFunction [dbo].[FN_TURNOVER_MONTHLY]    Script Date: 1/10/2022 7:44:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[FN_TURNOVER_MONTHLY](
@DATE1 DATETIME,
@DATE2 DATETIME

)
RETURNS TABLE AS RETURN
SELECT C.IdGroupProduct,D.NameGProduct, SUM(A.Amount) AS Amount FROM FinancialPaperDetail A, FinancialPaper B, Product C, GroupProduct D
WHERE A.KeyFinace = B.KeyFinance
AND A.BARCODE = C.BARCODE
AND C.IdGroupProduct = D.IdGroupProduct
AND B.Category in(3,4)
and B.Date >= CONVERT(DATETIME,@DATE1, 103)
and B.Date < CONVERT(DATETIME, @DATE2, 103)
GROUP BY C.IdGroupProduct, D.NameGProduct
GO
/****** Object:  Table [dbo].[Company]    Script Date: 1/10/2022 7:44:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Company](
	[IdCompany] [nvarchar](100) NOT NULL,
	[NameCompany] [nvarchar](100) NULL,
	[Phone] [nvarchar](50) NULL,
	[Fax] [nvarchar](50) NULL,
	[Address] [nvarchar](500) NULL,
	[Email] [nvarchar](100) NULL,
	[DISABLED] [bit] NULL,
 CONSTRAINT [PK_Company] PRIMARY KEY CLUSTERED 
(
	[IdCompany] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 1/10/2022 7:44:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[idCustom] [nvarchar](50) NOT NULL,
	[FullName] [nvarchar](50) NULL,
	[Phone] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Address] [nvarchar](500) NULL,
	[MST] [nvarchar](50) NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[idCustom] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Department]    Script Date: 1/10/2022 7:44:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[IdDepartment] [nvarchar](50) NOT NULL,
	[NameDepartment] [nvarchar](100) NULL,
	[Phone] [nvarchar](20) NULL,
	[Fax] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Address] [nvarchar](500) NULL,
	[IdCompany] [nvarchar](50) NULL,
	[DISABLED] [bit] NULL,
	[Syntax] [nvarchar](50) NULL,
	[STOCK] [bit] NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[IdDepartment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 1/10/2022 7:44:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[idOrder] [int] IDENTITY(1,1) NOT NULL,
	[NameProduct] [nvarchar](100) NULL,
	[Status] [bit] NULL,
	[CreateOrder] [datetime] NULL,
	[idCus] [nvarchar](50) NULL,
	[pay] [nvarchar](50) NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[idOrder] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 1/10/2022 7:44:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[idDetail] [int] IDENTITY(1,1) NOT NULL,
	[OrderId] [int] NULL,
	[ProductId] [nvarchar](50) NULL,
	[Quantity] [int] NULL,
 CONSTRAINT [PK_OrderDetail] PRIMARY KEY CLUSTERED 
(
	[idDetail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Source]    Script Date: 1/10/2022 7:44:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Source](
	[IdSource] [int] IDENTITY(1,1) NOT NULL,
	[NameSource] [nvarchar](500) NULL,
	[DISABLED] [bit] NULL,
 CONSTRAINT [PK_Source] PRIMARY KEY CLUSTERED 
(
	[IdSource] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 1/10/2022 7:44:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Supplier](
	[IdSupplier] [nvarchar](50) NOT NULL,
	[NameSupplier] [nvarchar](501) NULL,
	[Email] [nvarchar](50) NULL,
	[Phone] [nvarchar](50) NULL,
	[Fax] [nvarchar](50) NULL,
	[Address] [nvarchar](500) NULL,
	[CREATED_DATE] [datetime] NULL,
	[DISABLED] [bit] NULL,
 CONSTRAINT [PK_Supplier] PRIMARY KEY CLUSTERED 
(
	[IdSupplier] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SYS_FUNC]    Script Date: 1/10/2022 7:44:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SYS_FUNC](
	[FUNC_CODE] [nvarchar](200) NOT NULL,
	[SORT] [int] NULL,
	[DESCRIPTION] [nvarchar](500) NULL,
	[ISGROUP] [bit] NULL,
	[PARENT] [nvarchar](500) NULL,
	[MENU] [bit] NULL,
	[TIPS] [nvarchar](50) NULL,
 CONSTRAINT [PK_SYS_FUNC] PRIMARY KEY CLUSTERED 
(
	[FUNC_CODE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SYS_SEQUENCE]    Script Date: 1/10/2022 7:44:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SYS_SEQUENCE](
	[SEQNAME] [nvarchar](50) NOT NULL,
	[SEQVALUE] [int] NULL,
 CONSTRAINT [PK_SYS_SEQUENCE] PRIMARY KEY CLUSTERED 
(
	[SEQNAME] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Unit]    Script Date: 1/10/2022 7:44:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Unit](
	[IdUnit] [int] NOT NULL,
	[NameUnit] [nvarchar](100) NULL,
 CONSTRAINT [PK_Unit] PRIMARY KEY CLUSTERED 
(
	[IdUnit] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
