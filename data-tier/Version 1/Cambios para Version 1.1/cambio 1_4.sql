DROP procedure IF EXISTS `SEL_ListaCorreos`;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaCorreos`(in par_id_empresa varchar(30))
BEGIN
SELECT 
corrselec.id_id, 
corrselec.srvsmtpsal, 
corrselec.asunfac,  
corrselec.asuncot, 
corrselec.asuncontra,  
corrselec.asunord, 
corrselec.asunrec1, 
corrselec.asunrec2,
corrselec.asunrec3,
corrselec.cuerpfac,
corrselec.cuerpcot,
corrselec.cuerpcontra,
corrselec.cuerpord, 
corrselec.cuerprec1, 
corrselec.cuerprec2, 
corrselec.cuerprec3, 
corrselec.portsmtp, 
corrselec.actslenlog, 
corrselec.usr,  
corrselec.pass,  
corrselec.corralter,  
corrselec.idempresa,  
corrselec.estac,  
corrselec.estacglo,  
corrselec.sucu,
corrselec.nocaj, 
corrselec.extr1, 
corrselec.extr2, 
corrselec.extr3, 
corrselec.export, 
corrselec.falt, 
corrselec.fmod, 
estacs.NOM nombreestac
FROM corrselec 
LEFT OUTER JOIN estacs ON estacs.ESTAC = corrselec.ESTAC AND estacs.IDEMPRESA = corrselec.idempresa
WHERE corrselec.idempresa = par_id_empresa;
END$$

DELIMITER ;