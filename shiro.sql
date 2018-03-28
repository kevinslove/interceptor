DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Ȩ��id',
  `parentid` bigint(20) DEFAULT NULL COMMENT '���ڵ�id',
  `url` varchar(128) DEFAULT NULL COMMENT '����url,��/user/add.action',
  `permission_name` varchar(32) DEFAULT NULL COMMENT 'Ȩ����',
  `permission_sign` varchar(128) DEFAULT NULL COMMENT 'Ȩ�ޱ�ʶ,�������ж�ʹ��,��"user:create"',
  `description` varchar(256) DEFAULT NULL COMMENT 'Ȩ������,UI������ʾʹ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='Ȩ�ޱ�';

/*Data for the table `permission` */

insert  into `permission`(`id`,`parentid`,`url`,`permission_name`,`permission_sign`,`description`) values (1,NULL,'manager/','����Ա����','manager:admin',NULL),(2,1,'manager/role','��ɫ����','manager:role',NULL),(3,1,'manager/permission','Ȩ�޹���','manager:permission',NULL),(4,1,'manager/list','����Ա�б�','manager:list',NULL),(5,NULL,'system/','ϵͳ����','system:admin',NULL),(6,5,'system/seting','ϵͳ����','system:seting',NULL),(7,5,'system/menu','��Ŀ����','system.menu',NULL),(8,NULL,'articel/list','��Ѷ����','article:admin',NULL);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '��ɫid',
  `role_name` varchar(32) DEFAULT NULL COMMENT '��ɫ��',
  `role_sign` varchar(128) DEFAULT NULL COMMENT '��ɫ��ʶ,�������ж�ʹ��,��"admin"',
  `description` varchar(256) DEFAULT NULL COMMENT '��ɫ����,UI������ʾʹ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='��ɫ��';

/*Data for the table `role` */

insert  into `role`(`id`,`role_name`,`role_sign`,`description`) values (1,'admin','admin','����Ա');

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '��id',
  `role_id` bigint(20) unsigned DEFAULT NULL COMMENT '��ɫid',
  `permission_id` bigint(20) unsigned DEFAULT NULL COMMENT 'Ȩ��id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='��ɫ��Ȩ�޹�����';

/*Data for the table `role_permission` */

insert  into `role_permission`(`id`,`role_id`,`permission_id`) values (1,1,1),(2,1,2),(3,1,8);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '�û�id',
  `username` varchar(50) DEFAULT NULL COMMENT '�û���',
  `password` char(64) DEFAULT NULL COMMENT '����',
  `state` varchar(32) DEFAULT NULL COMMENT '״̬',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='�û���';

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`state`,`create_time`) values (1,'starzou','123456',NULL,'2014-07-17 12:59:08');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '��id',
  `user_id` bigint(20) unsigned DEFAULT NULL COMMENT '�û�id',
  `role_id` bigint(20) unsigned DEFAULT NULL COMMENT '��ɫid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='�û����ɫ������';

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`user_id`,`role_id`) values (1,1,1);