#v 1.1

#USE gas_campanita;
#SET @codigo = '2801169316';

USE campanita_gas_de_zacatecas;
SET @codigo = '282116111559';

#USE garob;
#SET @codigo = '189116132719';

#USE gas_casa_blanca;
#SET @codigo = '161116121627';

#USE gas_esmeralda;
#SET @codigo = '161116121541';

#USE transportes_cegu
#SET @codigo = '280116132926';

SELECT  @codigo, now();

DELETE FROM provs;

INSERT INTO provs(id_id,prov,ser,codclas,zon,giro,tentre,rubr,banc,clavbanc,lada,metpag,cta,enlada,nom,tel,entel,cel,encel,clasjera,exten,enexten,calle,encalle,
col,encol,cp,encp,ennoint,noint,noext,ennoext,ciu,enciu,estad,enestad,otramon,otramonc,bloq,ctaconta,revis,pags,pais,enpais,rfc,descu,diacred,limcred,
bloqlimcred,co1,enco1,co2,enco2,co3,enco3,pagweb1,pagweb2,eje1,telper1,entelper1,telper2,entelper2,eje2,telper21,telper22,observ,pers,contac3,
telcon3,telper3,telper33,contac4,telcon4,telper4,telper44,contac5,telcon5,telper5,telper55,contac6,telcon6,telper6,telper66,contac7,telcon7,
telper7,telper77,contac8,telcon8,telper8,telper88,contac9,telcon9,telper9,telper99,contac10,telcon10,telper10,telper100,idempresa,estac,sucu,
nocaj,export,extr1,extr2,extr3,falt,fmod,beneficiario)
SELECT * FROM campanita.provs WHERE idempresa = @codigo;

DELETE FROM er_movimientos_inventario;

DELETE FROM almas;

INSERT INTO almas
SELECT * FROM campanita.almas WHERE idempresa = @codigo;

DELETE FROM actfij;

INSERT INTO actfij
SELECT * FROM campanita.actfij WHERE idempresa = @codigo;

DELETE FROM actfijcat;

INSERT INTO actfijcat
SELECT * FROM campanita.actfijcat WHERE idempresa = @codigo;

DELETE FROM activos;

INSERT INTO activos
SELECT * FROM campanita.activos WHERE idempresa = @codigo;

DELETE FROM aduana;

INSERT INTO aduana
SELECT * FROM campanita.aduana;

DELETE FROM anaqs;

INSERT INTO anaqs
SELECT * FROM campanita.anaqs WHERE idempresa = @codigo;

DELETE FROM asientos_contables;

INSERT INTO asientos_contables
SELECT * FROM campanita.asientos_contables WHERE idempresa = @codigo;

DELETE FROM asocdesc;

INSERT INTO asocdesc
SELECT * FROM campanita.asocdesc WHERE idempresa = @codigo;

DELETE FROM auxiliar;

INSERT INTO auxiliar
SELECT * FROM campanita.auxiliar;

DELETE FROM banco;

INSERT INTO banco
SELECT * FROM campanita.banco WHERE idempresa = @codigo;

DELETE FROM basdats;

INSERT INTO basdats
SELECT * FROM campanita.basdats WHERE codemp = @codigo;

DELETE FROM c_aduana;

INSERT INTO c_aduana
SELECT * FROM campanita.c_aduana;

DELETE FROM c_claveprodserv;

INSERT INTO c_claveprodserv
SELECT * FROM campanita.c_claveprodserv;

DELETE FROM c_claveunidad;

INSERT INTO c_claveunidad
SELECT * FROM campanita.c_claveunidad;

DELETE FROM c_codigopostal;

INSERT INTO c_codigopostal
SELECT * FROM campanita.c_codigopostal;

DELETE FROM c_formapago;

INSERT INTO c_formapago
SELECT * FROM campanita.c_formapago ;

DELETE FROM c_metodopago;

INSERT INTO c_metodopago
SELECT * FROM campanita.c_metodopago;

DELETE FROM c_moneda;

INSERT INTO c_moneda
SELECT * FROM campanita.c_moneda;

DELETE FROM c_pais;

INSERT INTO c_pais
SELECT * FROM campanita.c_pais;

DELETE FROM c_regimenfiscal;

INSERT INTO c_regimenfiscal
SELECT * FROM campanita.c_regimenfiscal;

DELETE FROM c_tipodecomprobante;

INSERT INTO c_tipodecomprobante
SELECT * FROM campanita.c_tipodecomprobante;

DELETE FROM c_tiporelacion;

INSERT INTO c_tiporelacion
SELECT * FROM campanita.c_tiporelacion;

DELETE FROM c_usocfdi;

INSERT INTO c_usocfdi
SELECT * FROM campanita.c_usocfdi;

DELETE FROM cfdi_relacionados_pago;

INSERT INTO cfdi_relacionados_pago
SELECT * FROM cfdi_relacionados_pago;

DELETE FROM chat;

INSERT INTO chat
SELECT * FROM campanita.chat WHERE idempresa = @codigo;

DELETE FROM clasemp;

INSERT INTO clasemp
SELECT * FROM campanita.clasemp WHERE idempresa = @codigo;

DELETE FROM clasificacion;

INSERT INTO clasificacion
SELECT * FROM campanita.clasificacion WHERE idempresa = @codigo;

DELETE FROM clasjeracli;

INSERT INTO clasjeracli
SELECT * FROM campanita.clasjeracli WHERE idempresa = @codigo;

DELETE FROM clasjeraprod;

INSERT INTO clasjeraprod
SELECT * FROM campanita.clasjeraprod WHERE idempresa = @codigo;

DELETE FROM clasjeraprov;

INSERT INTO clasjeraprov
SELECT * FROM campanita.clasjeraprov WHERE idempresa = @codigo;

DELETE FROM clasprod;

INSERT INTO clasprod
SELECT * FROM campanita.clasprod WHERE idempresa = @codigo;

DELETE FROM clasprov;

INSERT INTO clasprov
SELECT * FROM campanita.clasprov WHERE idempresa = @codigo;

DELETE FROM colos;

INSERT INTO colos
SELECT * FROM campanita.colos WHERE idempresa = @codigo;

DELETE FROM compa;

INSERT INTO compa
SELECT * FROM campanita.compa WHERE idempresa = @codigo;

DELETE FROM comprs;

INSERT INTO comprs
SELECT * FROM campanita.comprs WHERE idempresa = @codigo;

DELETE FROM comprs_tmp;

INSERT INTO comprs_tmp
SELECT * FROM campanita.comprs_tmp WHERE idempresa = @codigo;

DELETE FROM concepnot;

INSERT INTO concepnot
SELECT * FROM campanita.concepnot WHERE idempresa = @codigo;

DELETE FROM conceppag;

INSERT INTO conceppag
SELECT * FROM campanita.conceppag WHERE idempresa = @codigo;

DELETE FROM conceps;

INSERT INTO conceps
SELECT * FROM campanita.conceps WHERE idempresa = @codigo;

DELETE FROM confgral;

INSERT INTO confgral
SELECT * FROM campanita.confgral WHERE idempresa = @codigo;

DELETE FROM consecs;

INSERT INTO consecs
SELECT * FROM campanita.consecs WHERE idempresa = @codigo;

DELETE FROM contras;

INSERT INTO contras
SELECT * FROM campanita.contras WHERE idempresa = @codigo;

DELETE FROM controlexportar;

INSERT INTO controlexportar
SELECT * FROM campanita.controlexportar WHERE idempresa = @codigo;

DELETE FROM correo_terminal;

INSERT INTO correo_terminal
SELECT * FROM campanita.correo_terminal WHERE idempresa = @codigo;

DELETE FROM corrselec;

INSERT INTO corrselec
SELECT * FROM campanita.corrselec WHERE idempresa = @codigo;

DELETE FROM cortszx;

INSERT INTO cortszx
SELECT * FROM campanita.cortszx WHERE idempresa = @codigo;

DELETE FROM costs;

INSERT INTO costs
SELECT * FROM campanita.costs WHERE idempresa = @codigo;

DELETE FROM cots;

INSERT INTO cots(id_id,    codcot,    proy,    motiv,    noser,    ser,    totdescu,    totcost,    vta,    norefer,    tipcam,    mon,    noservta,
    codemp,    observ,    idempresa,    estac,    sucu,    nocaj,    subtotgral,    subtotgral2,    subtot,    manobr,    impue,    subtotmat,
    subtotmat2,    tot,    descrip,    estad,    export,    extr1,    extr2,    extr3,    fdoc,    fentre,    fvenc,    falt,    fmod)
SELECT id_id,    codcot,    proy,    motiv,    noser,    ser,    totdescu,    totcost,    vta,    norefer,    tipcam,    mon,    noservta,
    codemp,    observ,    idempresa,    estac,    sucu,    nocaj,    subtotgral,    subtotgral2,    subtot,    manobr,    impue,
    subtotmat,    subtotmat2,    tot,    descrip,    estad,    export,    extr1,    extr2,    extr3,    fdoc,    fentre,    fvenc,    falt,
    fmod FROM campanita.cots WHERE idempresa = @codigo;

DELETE FROM cuentas_contables;

INSERT INTO cuentas_contables
SELECT * FROM campanita.cuentas_contables WHERE idempresa = @codigo;

DELETE FROM cumple;

INSERT INTO cumple
SELECT * FROM campanita.cumple WHERE idempresa = @codigo;

DELETE FROM cxc;

INSERT INTO cxc
SELECT * FROM campanita.cxc WHERE idempresa = @codigo;

DELETE FROM cxp;

INSERT INTO cxp
SELECT * FROM campanita.cxp WHERE idempresa = @codigo;

DELETE FROM datoscp;

INSERT INTO datoscp
SELECT * FROM campanita.datoscp WHERE idempresa = @codigo;

DELETE FROM documentos_contabilizados;

INSERT INTO documentos_contabilizados
SELECT * FROM campanita.documentos_contabilizados;

DELETE FROM documentos_origen;

INSERT INTO documentos_origen
SELECT * FROM campanita.documentos_origen;

DELETE FROM documentos_pago;

INSERT INTO documentos_pago
SELECT * FROM campanita.documentos_pago WHERE idempresa = @codigo;

DELETE FROM domentcli;

INSERT INTO domentcli
SELECT * FROM campanita.domentcli WHERE idempresa = @codigo;

DELETE FROM emps;

INSERT INTO emps
SELECT * FROM campanita.emps WHERE idempresa = @codigo;

DELETE FROM er_ejercicios;

INSERT INTO er_ejercicios
SELECT * FROM campanita.er_ejercicios;

DELETE FROM estacs;

INSERT INTO estacs
SELECT id_id, idempresa, estac, '', 52m, ptovta, descu, comi, habdesc, imptic, impfac, cort, pass, estacglo, calle, nom, col, cp, tel, cel, pai, ciu, esta, noint, res1path, res2path, res3path, rutmysq, noext, sucu, nocaj, export, admcaj, vend, mandagra, manddia, mandcump, extr1, extr2, extr3, falt, fmod, almacen FROM campanita.estacs WHERE idempresa = @codigo;

DELETE FROM er_permisos;

INSERT INTO er_permisos
SELECT * FROM campanita.er_permisos WHERE idempresa = @codigo;

DELETE FROM estadiscor;

INSERT INTO estadiscor
SELECT * FROM campanita.estadiscor WHERE idempresa = @codigo;

DELETE FROM existalma;

INSERT INTO existalma
SELECT * FROM campanita.existalma WHERE idempresa = @codigo;

DELETE FROM fabs;

INSERT INTO fabs
SELECT * FROM campanita.fabs WHERE idempresa = @codigo;

DELETE FROM facturas;

INSERT INTO facturas
SELECT * FROM campanita.facturas;

DELETE FROM fluj;

INSERT INTO fluj
SELECT * FROM campanita.fluj WHERE idempresa = @codigo;

DELETE FROM flujact;

INSERT INTO flujact
SELECT * FROM campanita.flujact WHERE idempresa = @codigo;

DELETE FROM garan;

INSERT INTO garan
SELECT * FROM campanita.garan WHERE idempresa = @codigo;

DELETE FROM giro;

INSERT INTO giro
SELECT * FROM campanita.giro WHERE idempresa = @codigo;

DELETE FROM grals;

INSERT INTO grals
SELECT * FROM grals WHERE idempresa = @codigo;

DELETE FROM impues_x_product;
DELETE FROM impuestos_venta;
DELETE FROM impuestos_x_compra;
DELETE FROM impuestos_x_venta;
DELETE FROM impues;
DELETE FROM prods;

INSERT INTO impues
SELECT * FROM campanita.impues WHERE idempresa = @codigo;

INSERT INTO prods
SELECT * FROM campanita.prods WHERE idempresa = @codigo;

INSERT INTO impues_x_product
SELECT * FROM campanita.impues_x_product WHERE idempresa = @codigo and produ in(SELECT prod FROM prods);

INSERT INTO impuestos_venta
SELECT * FROM campanita.impuestos_venta WHERE idempresa = @codigo;

INSERT INTO impuestos_x_compra
SELECT * FROM campanita.impuestos_x_compra WHERE idempresa = @codigo;

INSERT INTO impuestos_x_venta
SELECT * FROM campanita.impuestos_x_venta WHERE idempresa = @codigo;

DELETE FROM impuesxpartidaped;

INSERT INTO impuesxpartidaped
SELECT * FROM campanita.impuesxpartidaped WHERE idempresa = @codigo;
DELETE FROM ingres;
DELETE FROM ingresos_encab;

INSERT INTO ingresos_encab(id_id,alma,concep,canttotal,idempresa,estac,sucu,entsal,nocaj,export,extr1,extr2,extr3,falt, lote, pedimento, caducidad)
SELECT id_id,alma,concep,canttotal,idempresa,estac,sucu,entsal,nocaj,export,extr1,extr2,extr3,falt, '', '', '1700-01-01' FROM campanita.ingresos_encab WHERE idempresa = @codigo;

INSERT INTO ingres(`id_id`,
`idIngresCab`,
`prod`,
`alma`,
`unid`,
`concep`,
`cant`,
`idempresa`,
`estac`,
`sucu`,
`entsal`,
`nocaj`,
`export`,
`extr1`,
`extr2`,
`extr3`,
`activo`,
`falt`,
`costo`,
`cantsal`,
`tipcamnac`)
SELECT `id_id`,
`idIngresCab`,
`prod`,
`alma`,
`unid`,
`concep`,
`cant`,
`idempresa`,
`estac`,
`sucu`,
`entsal`,
`nocaj`,
`export`,
`extr1`,
`extr2`,
`extr3`,
`activo`,
`falt`,
`costo`,
`cantsal`,
`tipcamnac`
 FROM campanita.ingres WHERE idempresa = @codigo;

DELETE FROM interbd;

INSERT INTO interbd
SELECT * FROM campanita.interbd WHERE idempresa = @codigo;

DELETE FROM interdpark;

INSERT INTO interdpark
SELECT * FROM campanita.interdpark WHERE idempresa = @codigo;

DELETE FROM kits;

INSERT INTO kits
SELECT * FROM campanita.kits WHERE idempresa = @codigo;

DELETE FROM lins;

INSERT INTO lins
SELECT * FROM campanita.lins WHERE idempresa = @codigo;

DELETE FROM logactcat;

INSERT INTO logactcat
SELECT * FROM campanita.logactcat WHERE idempresa = @codigo;

DELETE FROM logacttip;

INSERT INTO logacttip
SELECT * FROM campanita.logacttip WHERE idempresa = @codigo;

DELETE FROM logalmas;

INSERT INTO logalmas
SELECT * FROM campanita.logalmas WHERE idempresa = @codigo;

DELETE FROM loganaq;

INSERT INTO loganaq
SELECT * FROM campanita.loganaq WHERE idempresa = @codigo;

DELETE FROM logbanco;

INSERT INTO logbanco
SELECT * FROM campanita.logbanco WHERE idempresa = @codigo;

DELETE FROM logcatgral;

INSERT INTO logcatgral
SELECT * FROM campanita.logcatgral WHERE idempresa = @codigo;

DELETE FROM logclasemp;

INSERT INTO logclasemp
SELECT * FROM campanita.logclasemp WHERE idempresa = @codigo;

DELETE FROM logclasext;

INSERT INTO logclasext
SELECT * FROM campanita.logclasext WHERE idempresa = @codigo;

DELETE FROM logclasificacion;

INSERT INTO logclasificacion
SELECT * FROM campanita.logclasificacion WHERE idempresa = @codigo;

DELETE FROM logclasprov;

INSERT INTO logclasprov
SELECT * FROM campanita.logclasprov WHERE idempresa = @codigo;

DELETE FROM logcolo;

INSERT INTO logcolo
SELECT * FROM campanita.logcolo WHERE idempresa = @codigo;

DELETE FROM logconcep;

INSERT INTO logconcep
SELECT * FROM campanita.logconcep WHERE idempresa = @codigo;

DELETE FROM logconcnot;

INSERT INTO logconcnot
SELECT * FROM campanita.logconcnot WHERE idempresa = @codigo;

DELETE FROM logconcpag;

INSERT INTO logconcpag
SELECT * FROM campanita.logconcpag WHERE idempresa = @codigo;

DELETE FROM logcorrs;

INSERT INTO logcorrs
SELECT * FROM campanita.logcorrs WHERE idempresa = @codigo;

DELETE FROM logcuentas;

INSERT INTO logcuentas
SELECT * FROM campanita.logcuentas WHERE idempresa = @codigo;

DELETE FROM logemps;

INSERT INTO logemps
SELECT * FROM campanita.logemps WHERE idempresa = @codigo;

DELETE FROM logestac;

INSERT INTO logestac
SELECT * FROM campanita.logestac WHERE idempresa = @codigo;

DELETE FROM logfabs;

INSERT INTO logfabs
SELECT * FROM campanita.logfabs WHERE idempresa = @codigo;

DELETE FROM loggara;

INSERT INTO loggara
SELECT * FROM campanita.loggara WHERE idempresa = @codigo;

DELETE FROM loggiro;

INSERT INTO loggiro
SELECT * FROM campanita.loggiro WHERE idempresa = @codigo;

DELETE FROM logimpue;

INSERT INTO logimpue
SELECT * FROM campanita.logimpue WHERE idempresa = @codigo;

DELETE FROM logini;

INSERT INTO logini
SELECT * FROM campanita.logini WHERE idempresa = @codigo;

DELETE FROM logkit;

INSERT INTO logkit
SELECT * FROM campanita.logkit WHERE idempresa = @codigo;

DELETE FROM loglins;

INSERT INTO loglins
SELECT * FROM campanita.loglins WHERE idempresa = @codigo;

DELETE FROM loglugs;

INSERT INTO loglugs
SELECT * FROM campanita.loglugs WHERE idempresa = @codigo;

DELETE FROM logmarc;

INSERT INTO logmarc
SELECT * FROM campanita.logmarc WHERE idempresa = @codigo;

DELETE FROM logmed;

INSERT INTO logmed
SELECT * FROM campanita.logmed WHERE idempresa = @codigo;

DELETE FROM logmod;

INSERT INTO logmod
SELECT * FROM campanita.logmod WHERE idempresa = @codigo;

DELETE FROM logmons;

INSERT INTO logmons
SELECT * FROM campanita.logmons WHERE idempresa = @codigo;

DELETE FROM logpes;

INSERT INTO logpes
SELECT * FROM campanita.logpes WHERE idempresa = @codigo;

DELETE FROM logprods;

INSERT INTO logprods
SELECT * FROM campanita.logprods WHERE idempresa = @codigo;

DELETE FROM logprovs;

INSERT INTO logprovs
SELECT * FROM campanita.logprovs WHERE idempresa = @codigo;

DELETE FROM logresponsable;

INSERT INTO logresponsable
SELECT * FROM campanita.logresponsable WHERE idempresa = @codigo;

DELETE FROM logsucursal;

INSERT INTO logsucursal
SELECT * FROM campanita.logsucursal WHERE idempresa = @codigo;

DELETE FROM logtall;

INSERT INTO logtall
SELECT * FROM campanita.logtall WHERE idempresa = @codigo;

DELETE FROM logtip;

INSERT INTO logtip
SELECT * FROM campanita.logtip WHERE idempresa = @codigo;

DELETE FROM logubiad;

INSERT INTO logubiad
SELECT * FROM campanita.logubiad WHERE idempresa = @codigo;

DELETE FROM logunid;

INSERT INTO logunid
SELECT * FROM campanita.logunid WHERE idempresa = @codigo;

DELETE FROM logzona;

INSERT INTO logzona
SELECT * FROM campanita.logzona WHERE idempresa = @codigo;

DELETE FROM lotped;

INSERT INTO lotped
SELECT * FROM campanita.lotped WHERE idempresa = @codigo;

DELETE FROM lugs;

INSERT INTO lugs
SELECT * FROM campanita.lugs WHERE idempresa = @codigo;

DELETE FROM marcprod;

INSERT INTO marcprod
SELECT * FROM campanita.marcprod WHERE idempresa = @codigo;

DELETE FROM marcs;

INSERT INTO marcs
SELECT * FROM campanita.marcs WHERE idempresa = @codigo;

DELETE FROM maxminconf;

INSERT INTO maxminconf
SELECT * FROM campanita.maxminconf WHERE idempresa = @codigo;

DELETE FROM meds;

INSERT INTO meds
SELECT * FROM campanita.meds WHERE idempresa = @codigo;

DELETE FROM model;

INSERT INTO model
SELECT * FROM campanita.model WHERE idempresa = @codigo;

DELETE FROM modelprod;

INSERT INTO modelprod
SELECT * FROM campanita.modelprod WHERE idempresa = @codigo;

DELETE FROM modifica_impuestos;

INSERT INTO modifica_impuestos
SELECT * FROM campanita.modifica_impuestos;

DELETE FROM moninven;

INSERT INTO moninven
SELECT * FROM campanita.moninven WHERE idempresa = @codigo;

DELETE FROM mons;

INSERT INTO mons
SELECT * FROM campanita.mons WHERE idempresa = @codigo;

DELETE FROM movimientos_asientos;

INSERT INTO movimientos_asientos
SELECT * FROM campanita.movimientos_asientos where idAsiento in (select id from campanita.asientos_contables where idempresa = @codigo);

DELETE FROM movimientos_pagos;

INSERT INTO movimientos_pagos
SELECT * FROM campanita.movimientos_pagos ;

DELETE FROM msjs;

INSERT INTO msjs
SELECT * FROM campanita.msjs WHERE idempresa = @codigo;

DELETE FROM ords;

INSERT INTO ords
SELECT * FROM campanita.ords WHERE idempresa = @codigo;

DELETE FROM pags;

INSERT INTO pags
SELECT * FROM campanita.pags;

DELETE FROM partcomprs;

INSERT INTO partcomprs
SELECT * FROM campanita.partcomprs WHERE idempresa = @codigo;

DELETE FROM partcomprs_tmp;

INSERT INTO partcomprs_tmp
SELECT * FROM campanita.partcomprs_tmp WHERE idempresa = @codigo;

DELETE FROM partcot;

INSERT INTO partcot(id_id,    codcot,    prod,    tipcam,    cost,    unid,    mon,    cant,    descrip,    eskit,    serprod,    comenser,    tall,
    fentre,    codimpue,    colo,    garan,    list,    lot,    pedimen,    fcadu,    pre,    pre2,    desc1,    desc2,    desc3,    desc4,    desc5,
    impo,    impo2,    impueval,    impueimpo,    impueimpo2,    impodesc,    alma,    idempresa,    export,    extr1,    extr2,    extr3,    falt,    fmod)
SELECT id_id,    codcot,    prod,    tipcam,    cost,    unid,    mon,    cant,    descrip,    eskit,    serprod,    comenser,    tall,
    fentre,    codimpue,    colo,    garan,    list,    lot,    pedimen,    fcadu,    pre,    pre2,    desc1,    desc2,    desc3,    desc4,    desc5,
    impo,    impo2,    impueval,    impueimpo,    impueimpo2,    impodesc,    alma,    idempresa,    export,    extr1,    extr2,    extr3,    falt,    fmod
    FROM campanita.partcot WHERE idempresa = @codigo;

DELETE FROM partflujact;

INSERT INTO partflujact
SELECT * FROM campanita.partflujact WHERE idempresa = @codigo;

DELETE FROM partords;

INSERT INTO partords
SELECT * FROM campanita.partords WHERE idempresa = @codigo;

DELETE FROM partprevcomprs;

INSERT INTO partprevcomprs
SELECT * FROM campanita.partprevcomprs WHERE idempresa = @codigo;

DELETE FROM partprevcomprs_tmp;

INSERT INTO partprevcomprs_tmp
SELECT * FROM campanita.partprevcomprs_tmp WHERE idempresa = @codigo;

DELETE FROM partvta;

INSERT INTO partvta(id_id,
    prod,
    vta,
    tipdoc,
    cant,
    tipcam,
    devs,
    garan,
    eskit,
    kitmae,
    idkit,
    idlotped,
    list,
    unid,
    codimpue,
    alma,
    serprod,
    comenser,
    descrip,
    pre,
    descu,
    costprom,
    cost,
    idultcost,
    peps,
    idpeps,
    ueps,
    idueps,
    mon,
    lot,
    pedimen,
    fcadu,
    impo,
    impue,
    tall,
    colo,
    cantentre,
    entrenow,
    export,
    idempresa,
    extr1,
    extr2,
    extr3,
    fentre,
    falt,
    fmod,
    activo,
    cuentacontable,
    lotePedimento,
    monedaID,
    partidaIdOriginal,
    descripcionOpcional)
SELECT id_id,
    prod,
    vta,
    tipdoc,
    cant,
    tipcam,
    devs,
    garan,
    eskit,
    kitmae,
    idkit,
    idlotped,
    list,
    unid,
    codimpue,
    alma,
    serprod,
    comenser,
    descrip,
    pre,
    descu,
    costprom,
    cost,
    idultcost,
    peps,
    idpeps,
    ueps,
    idueps,
    mon,
    lot,
    pedimen,
    fcadu,
    impo,
    impue,
    tall,
    colo,
    cantentre,
    entrenow,
    export,
    idempresa,
    extr1,
    extr2,
    extr3,
    fentre,
    falt,
    fmod,
    ifnull(activo,''),
    cuentacontable,
    lotePedimento,
    monedaID,
    partidaIdOriginal,
    descripcionOpcional FROM campanita.partvta WHERE idempresa = @codigo;

DELETE FROM pedidos;

INSERT INTO pedidos
SELECT * FROM campanita.pedidos WHERE idempresa = @codigo;

DELETE FROM pedidos_parts;

INSERT INTO pedidos_parts
SELECT * FROM campanita.pedidos_parts WHERE idempresa = @codigo;

DELETE FROM pers;

INSERT INTO pers
SELECT * FROM campanita.pers WHERE idempresa = @codigo;

DELETE FROM pes;

INSERT INTO pes
SELECT * FROM campanita.pes WHERE idempresa = @codigo;

DELETE FROM petis;

INSERT INTO petis
SELECT * FROM campanita.petis WHERE idempresa = @codigo;

DELETE FROM prevcomprs;

INSERT INTO prevcomprs
SELECT * FROM campanita.prevcomprs WHERE idempresa = @codigo;

DELETE FROM prodpart;

INSERT INTO prodpart
SELECT * FROM campanita.prodpart WHERE idempresa = @codigo;

DELETE FROM proys;

INSERT INTO proys
SELECT * FROM campanita.proys WHERE idempresa = @codigo;

DELETE FROM registroemail;

INSERT INTO registroemail
SELECT * FROM campanita.registroemail WHERE idempresa = @codigo;

DELETE FROM resp;

INSERT INTO resp
SELECT * FROM campanita.resp WHERE idempresa = @codigo;

DELETE FROM resplog;

INSERT INTO resplog
SELECT * FROM campanita.resplog WHERE idempresa = @codigo;

DELETE FROM responsable;

INSERT INTO responsable
SELECT * FROM campanita.responsable WHERE idempresa = @codigo;

DELETE FROM rubr;

INSERT INTO rubr
SELECT * FROM campanita.rubr WHERE idempresa = @codigo;

DELETE FROM ruts;

INSERT INTO ruts
SELECT * FROM campanita.ruts WHERE idempresa = @codigo;

DELETE FROM sectores;

INSERT INTO sectores
SELECT * FROM campanita.sectores;

DELETE FROM serieprod;

INSERT INTO serieprod
SELECT * FROM campanita.serieprod WHERE idempresa = @codigo;

DELETE FROM subramos;

INSERT INTO subramos
SELECT * FROM campanita.subramos;

DELETE FROM sucursal;

INSERT INTO sucursal
SELECT * FROM campanita.sucursal WHERE idempresa = @codigo;

DELETE FROM tall;

INSERT INTO tall
SELECT * FROM campanita.tall WHERE idempresa = @codigo;

DELETE FROM tallcolo;

INSERT INTO tallcolo
SELECT * FROM campanita.tallcolo WHERE idempresa = @codigo;

DELETE FROM tars;

INSERT INTO tars
SELECT * FROM campanita.tars WHERE idempresa = @codigo;

DELETE FROM termarcamodelo;

INSERT INTO termarcamodelo
SELECT * FROM campanita.termarcamodelo WHERE idempresa = @codigo;

DELETE FROM termarcamodelo;

INSERT INTO termarcamodelo
SELECT * FROM campanita.termarcamodelo WHERE idempresa = @codigo;

DELETE FROM terprodcompa;

INSERT INTO terprodcompa
SELECT * FROM campanita.terprodcompa WHERE idempresa = @codigo;

DELETE FROM tips;

INSERT INTO tips
SELECT * FROM campanita.tips WHERE idempresa = @codigo;

DELETE FROM tipactfij;

INSERT INTO tipactfij
SELECT * FROM campanita.tipactfij WHERE idempresa = @codigo;

DELETE FROM tipscamb;

INSERT INTO tipscamb
SELECT * FROM campanita.tipscamb WHERE idempresa = @codigo;

DELETE FROM traspas;

INSERT INTO traspas
SELECT * FROM campanita.traspas WHERE idempresa = @codigo;

DELETE FROM ubiad;

INSERT INTO ubiad
SELECT * FROM campanita.ubiad WHERE idempresa = @codigo;

DELETE FROM unids;

INSERT INTO unids
SELECT * FROM campanita.unids WHERE idempresa = @codigo;

DELETE FROM usuarioserie;

INSERT INTO usuarioserie
SELECT * FROM campanita.usuarioserie WHERE idempresa = @codigo;

DELETE FROM viats;

INSERT INTO viats
SELECT * FROM campanita.viats WHERE idempresa = @codigo;

DELETE FROM viatspro;

INSERT INTO viatspro
SELECT * FROM campanita.viatspro WHERE idempresa = @codigo;

DELETE FROM vtas;

INSERT INTO vtas
SELECT * FROM campanita.vtas WHERE idempresa = @codigo;

DELETE FROM zona;

INSERT INTO zona
SELECT * FROM campanita.zona WHERE idempresa = @codigo;

INSERT INTO er_movimientos_inventario
(idAlmacen,idMovtoComercial,idProducto,tipoMovimiento,cantidad,unidad,costoUnitario,costoPromedio,existActual,idempresa,fechaMovimiento,timestamp,lotePedimento)
SELECT 
a2.id_id as idAlmacen
,eri.idMovtoComercial
,p2.id_id as idProducto
,eri.tipoMovimiento
,eri.cantidad
,eri.unidad
,eri.costoUnitario
,eri.costoPromedio
,eri.existActual
,eri.idempresa
,eri.fechaMovimiento
,eri.timestamp
,eri.lotePedimento
FROM campanita.er_movimientos_inventario eri
LEFT OUTER JOIN campanita.almas a1 ON eri.idAlmacen = a1.id_id
LEFT OUTER JOIN almas a2 ON a1.alma = a2.alma
LEFT OUTER JOIN campanita.prods p1 ON eri.idProducto = p1.id_id
LEFT OUTER JOIN prods p2 ON p1.prod = p2.prod
WHERE eri.idempresa =  @codigo
AND p2.id_id is not null and a2.id_id is not null;

#INSERT INTO impues_x_product(produ, impue, idempresa, estac, sucu, nocaj)
#SELECT DISTINCT prod , 'IVA', idempresa, 'SUP', 'SUCURSAL', 'CAJA' from campanita.prods WHERE idempresa = @codigo;


SELECT  @codigo, now();