USE [master]
GO
/****** Object:  Database [PolyCafe]    Script Date: 6/5/2025 11:24:11 AM ******/
CREATE DATABASE [PolyCafe]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PolyCafe', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PolyCafe.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PolyCafe_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PolyCafe_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [PolyCafe] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PolyCafe].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PolyCafe] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PolyCafe] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PolyCafe] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PolyCafe] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PolyCafe] SET ARITHABORT OFF 
GO
ALTER DATABASE [PolyCafe] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PolyCafe] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PolyCafe] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PolyCafe] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PolyCafe] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PolyCafe] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PolyCafe] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PolyCafe] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PolyCafe] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PolyCafe] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PolyCafe] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PolyCafe] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PolyCafe] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PolyCafe] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PolyCafe] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PolyCafe] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PolyCafe] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PolyCafe] SET RECOVERY FULL 
GO
ALTER DATABASE [PolyCafe] SET  MULTI_USER 
GO
ALTER DATABASE [PolyCafe] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PolyCafe] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PolyCafe] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PolyCafe] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PolyCafe] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PolyCafe] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'PolyCafe', N'ON'
GO
ALTER DATABASE [PolyCafe] SET QUERY_STORE = OFF
GO
USE [PolyCafe]
GO
/****** Object:  Table [dbo].[BillDetails]    Script Date: 6/5/2025 11:24:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillDetails](
	[Id] [bigint] IDENTITY(100000,1) NOT NULL,
	[BillId] [bigint] NOT NULL,
	[DrinkId] [nvarchar](20) NOT NULL,
	[UnitPrice] [float] NOT NULL,
	[Discount] [float] NOT NULL,
	[Quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bills]    Script Date: 6/5/2025 11:24:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bills](
	[Id] [bigint] IDENTITY(10000,1) NOT NULL,
	[Username] [nvarchar](20) NOT NULL,
	[CardId] [int] NOT NULL,
	[Checkin] [datetime] NOT NULL,
	[Checkout] [datetime] NULL,
	[Status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cards]    Script Date: 6/5/2025 11:24:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cards](
	[Id] [int] NOT NULL,
	[Status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 6/5/2025 11:24:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [nvarchar](20) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Drinks]    Script Date: 6/5/2025 11:24:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Drinks](
	[Id] [nvarchar](20) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[UnitPrice] [float] NOT NULL,
	[Discount] [float] NOT NULL,
	[Image] [nvarchar](50) NOT NULL,
	[Available] [bit] NOT NULL,
	[CategoryId] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 6/5/2025 11:24:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[Username] [nvarchar](20) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Enabled] [bit] NOT NULL,
	[Fullname] [nvarchar](50) NOT NULL,
	[Photo] [nvarchar](50) NOT NULL,
	[Manager] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[BillDetails]  WITH CHECK ADD FOREIGN KEY([BillId])
REFERENCES [dbo].[Bills] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[BillDetails]  WITH CHECK ADD FOREIGN KEY([DrinkId])
REFERENCES [dbo].[Drinks] ([Id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Bills]  WITH CHECK ADD FOREIGN KEY([CardId])
REFERENCES [dbo].[Cards] ([Id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Bills]  WITH CHECK ADD FOREIGN KEY([Username])
REFERENCES [dbo].[Users] ([Username])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Drinks]  WITH CHECK ADD FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Categories] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
USE [master]
GO
ALTER DATABASE [PolyCafe] SET  READ_WRITE 
GO
