DELETE FROM "handlerIds" WHERE handlerId='com.mobileread.ixtab.kindlelauncher';
DELETE FROM "properties" WHERE handlerId='com.mobileread.ixtab.kindlelauncher';
DELETE FROM "associations" WHERE handlerId='com.mobileread.ixtab.kindlelauncher';

DELETE FROM "mimetypes" WHERE ext='kual';
DELETE FROM "extenstions" WHERE ext='kual';
DELETE FROM "properties" WHERE value='KUAL';
DELETE FROM "associations" WHERE contentId='GL:*.kual';
