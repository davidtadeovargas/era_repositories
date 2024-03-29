DROP PROCEDURE IF EXISTS SEL_ProductoPorProd;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ProductoPorProd`(
	IN par_id_empresa varchar(30),
    IN par_prod varchar(30)
)
BEGIN
SELECT alma,
    anaq,
    bajcost,
    clavesat
    codubi,
    comenser,
    compue,
    cost,
    costre,
    descrip, 
    descripcort,
    estac,
    estaccrea,
    esvta,
    exist,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fcadu,
    fmod,
    idempresa,
    impue,
    infor,
    invent,
    lote,
    lotped,
    lug,
    max,
    metcost,
    min,
    nocaj,
    noser, 
    pedimen,
    pesman,
    prelist1,
    prelist10,
    prelist2,
    prelist3,
    prelist4,
    prelist5,
    prelist6,
    prelist7,
    prelist8,
    prelist9,
    prod,
    rutimg,
    servi,
    solmaxmin, 
    solser,
    sucu,
    unid,
    utilvta1,
    utilvta10,
    utilvta2,
    utilvta3,
    utilvta4,
    utilvta5,
    utilvta6,
    utilvta7,
    utilvta8,
    utilvta9,
    clavesat
FROM prods WHERE prod = par_prod and idempresa=par_id_empresa;
END$$
DELIMITER ;
