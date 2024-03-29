USE [FTS]
GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 08/27/2021 11:35:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategory](
	[_id] [int] IDENTITY(1,1) NOT NULL,
	[_name] [varchar](50) NOT NULL,
	[_description] [varchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblCourse]    Script Date: 08/27/2021 11:35:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCourse](
	[_id] [int] IDENTITY(1,1) NOT NULL,
	[_name] [varchar](50) NOT NULL,
	[_thumbnail] [varchar](255) NULL,
	[_start_date] [date] NOT NULL,
	[_end_date] [date] NOT NULL,
	[_course_created_date] [date] NOT NULL,
	[_content] [varchar](255) NULL,
	[_description] [varchar](255) NULL,
	[_enroll_code] [varchar](50) NULL,
	[_category_id] [int] NOT NULL,
	[_topic_id] [int] NOT NULL,
 CONSTRAINT [PK__tblCours__DED88B1C418D8B7C] PRIMARY KEY CLUSTERED 
(
	[_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRole]    Script Date: 08/27/2021 11:35:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRole](
	[_id] [int] NOT NULL,
	[_name] [varchar](50) NOT NULL,
	[_description] [varchar](200) NULL,
 CONSTRAINT [PK__tblRole__DED88B1C44B82D54] PRIMARY KEY CLUSTERED 
(
	[_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblTopic]    Script Date: 08/27/2021 11:35:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblTopic](
	[_id] [int] IDENTITY(1,1) NOT NULL,
	[_name] [varchar](50) NOT NULL,
	[_description] [varchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 08/27/2021 11:35:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[_id] [int] IDENTITY(1,1) NOT NULL,
	[_username] [varchar](50) NOT NULL,
	[_password] [varchar](50) NOT NULL,
	[_email] [varchar](50) NOT NULL,
	[_firstname] [varchar](50) NOT NULL,
	[_lastname] [varchar](50) NOT NULL,
	[_avatar] [varchar](255) NULL,
	[_phone] [varchar](50) NULL,
	[_detail] [varchar](200) NULL,
	[_address] [varchar](250) NULL,
	[_role_id] [int] NOT NULL,
	[_dob] [date] NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UQ__tblUser__CFAA5BB25E5D0617] UNIQUE NONCLUSTERED 
(
	[_email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUser_course]    Script Date: 08/27/2021 11:35:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser_course](
	[_user_id] [int] NULL,
	[_course_id] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUser_topic]    Script Date: 08/27/2021 11:35:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser_topic](
	[_user_id] [int] NULL,
	[_topic_id] [int] NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tblCourse]  WITH CHECK ADD  CONSTRAINT [FK__tblCourse___cate__2CF2ADDF] FOREIGN KEY([_category_id])
REFERENCES [dbo].[tblCategory] ([_id])
GO
ALTER TABLE [dbo].[tblCourse] CHECK CONSTRAINT [FK__tblCourse___cate__2CF2ADDF]
GO
ALTER TABLE [dbo].[tblCourse]  WITH CHECK ADD  CONSTRAINT [FK__tblCourse___topi__2DE6D218] FOREIGN KEY([_topic_id])
REFERENCES [dbo].[tblTopic] ([_id])
GO
ALTER TABLE [dbo].[tblCourse] CHECK CONSTRAINT [FK__tblCourse___topi__2DE6D218]
GO
ALTER TABLE [dbo].[tblUser]  WITH CHECK ADD  CONSTRAINT [FK__tblUser___role_i__2739D489] FOREIGN KEY([_role_id])
REFERENCES [dbo].[tblRole] ([_id])
GO
ALTER TABLE [dbo].[tblUser] CHECK CONSTRAINT [FK__tblUser___role_i__2739D489]
GO
ALTER TABLE [dbo].[tblUser_course]  WITH CHECK ADD  CONSTRAINT [FK__tblUser_Course] FOREIGN KEY([_course_id])
REFERENCES [dbo].[tblCourse] ([_id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblUser_course] CHECK CONSTRAINT [FK__tblUser_Course]
GO
ALTER TABLE [dbo].[tblUser_course]  WITH CHECK ADD  CONSTRAINT [FK_tblUser_course_tblUser] FOREIGN KEY([_user_id])
REFERENCES [dbo].[tblUser] ([_id])
GO
ALTER TABLE [dbo].[tblUser_course] CHECK CONSTRAINT [FK_tblUser_course_tblUser]
GO
ALTER TABLE [dbo].[tblUser_topic]  WITH CHECK ADD FOREIGN KEY([_topic_id])
REFERENCES [dbo].[tblTopic] ([_id])
GO
ALTER TABLE [dbo].[tblUser_topic]  WITH CHECK ADD  CONSTRAINT [FK_tblUser_topic_tblUser] FOREIGN KEY([_user_id])
REFERENCES [dbo].[tblUser] ([_id])
GO
ALTER TABLE [dbo].[tblUser_topic] CHECK CONSTRAINT [FK_tblUser_topic_tblUser]
GO
