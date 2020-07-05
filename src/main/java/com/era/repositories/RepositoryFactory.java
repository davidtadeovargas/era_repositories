package com.era.repositories;

import com.era.logger.LoggerUtility;

public class RepositoryFactory {

   private static RepositoryFactory RepositoryFactory;

   private ActfijcatsRepository ActfijcatsRepository;
   private ActfijsRepository ActfijsRepository;
   private ActivossRepository ActivossRepository;
   private AduanasRepository AduanasRepository;
   private AnaqssRepository AnaqssRepository;
   private AsientosContablessRepository AsientosContablessRepository;
   private AsocdescsRepository AsocdescsRepository;
   private AuxiliarsRepository AuxiliarsRepository;
   private BancosRepository BancosRepository;
   private BasDatssRepository BasDatssRepository;
   private CAduanasRepository CAduanasRepository;
   private CClaveprodservsRepository CClaveprodservsRepository;
   private CClaveUnidadsRepository CClaveUnidadsRepository;
   private CCodigoPostalRepository CCodigoPostalRepository;
   private CCoinsRepository CCoinsRepository;
   private CCountriesRepository CCountriesRepository;
   private CFDIRelacionadosPagosRepository CFDIRelacionadosPagosRepository;
   private ClasificacionsRepository ClasificacionsRepository;
   private CoinsRepository CoinsRepository;
   private CompanysRepository CompanysRepository;
   private CompasRepository CompasRepository;
   private ComprsRepository ComprsRepository;
   private ComprssRepository ComprssRepository;
   private ComprsTmpsRepository ComprsTmpsRepository;
   private PaymentsSalesRepository PaymentsSalesRepository;
   private ConcepnotsRepository ConcepnotsRepository;
   private ConceppagsRepository ConceppagsRepository;
   private ConcepssRepository ConcepssRepository;
   private ConfgralRepository ConfgralRepository; 
   private ConsecsRepository ConsecsRepository;
   private ControlexportarsRepository ControlexportarsRepository;
   private CorreoTerminalsRepository CorreoTerminalsRepository;
   private CorrselecRepository CorrselecRepository;
   private CorrselecsRepository CorrselecsRepository;
   private CortessRepository CortessRepository;
   private CortszxsRepository CortszxsRepository;
   private CostssRepository CostssRepository;
   private CotssRepository CotssRepository;
   private CountriesRepository CountriesRepository;
   private CPaymentFormsRepository CPaymentFormsRepository;
   private CPaymentMethodsRepository CPaymentMethodsRepository;
   private CRegimenFiscalRepository CRegimenFiscalRepository;
   private CTipoComprobantesRepository CTipoComprobantesRepository;
   private CTipoRelacionsRepository CTipoRelacionsRepository;
   private CuentasContablesRepository CuentasContablesRepository;
   private CuentasContablessRepository CuentasContablessRepository;
   private CUsoCFDIsRepository CUsoCFDIsRepository;
   private CxcRepository CxcRepository;
   private CxcsRepository CxcsRepository;
   private CxpRepository CxpRepository;
   private CxpsRepository CxpsRepository;
   private DatoscpsRepository DatoscpsRepository;
   private DocumentOriginRepository DocumentOriginRepository;   
   private DocumentosContabilizadossRepository DocumentosContabilizadossRepository;
   private DocumentosOrigensRepository DocumentosOrigensRepository;
   private DocumentosPagosRepository DocumentosPagosRepository;
   private EREjerciciossRepository EREjerciciossRepository;
   private ERMmovimientosInventariosRepository ERMmovimientosInventariosRepository;
   private ERPermisosRepository ERPermisosRepository;
   private ERPermisossRepository ERPermisossRepository;
   private ExistalmasRepository ExistalmasRepository;
   private FabssRepository FabssRepository;
   private FacturassRepository FacturassRepository;
   private FlujactsRepository FlujactsRepository;
   private FlujsRepository FlujsRepository;
   private GaransRepository GaransRepository;
   private GeneralConfigsRepository GeneralConfigsRepository;
   private GiroRepository GiroRepository;
   private GirosRepository GirosRepository;
   private HistAntiguedaddesaldosRepository HistAntiguedaddesaldosRepository;
   private ImpuestosVentasRepository ImpuestosVentasRepository;
   private ImpuestosXComprasRepository ImpuestosXComprasRepository;
   private ImpuestosXVentasRepository ImpuestosXVentasRepository;
   private ImpuesxpartidacotsRepository ImpuesxpartidacotsRepository;
   private ImpuesxpartidapedsRepository ImpuesxpartidapedsRepository;
   private ImpuesXProductRepository ImpuesXProductRepository;   
   private IngresosEncabRepository IngresosEncabRepository;   
   private IngresRepository IngresRepository;   
   private KitssRepository KitssRepository;
   private LicensesRepository LicensesRepository;
   private LinesRepository LinesRepository;
   private LogsRepository LogsRepository;
   private LotpedRepository LotpedRepository;
   private LugssRepository LugssRepository;
   private MarcprodsRepository MarcprodsRepository;
   private MarcssRepository MarcssRepository;
   private MaxminconfsRepository MaxminconfsRepository;
   private MeasuresRepository MeasuresRepository;
   private MedssRepository MedssRepository;
   private MetogoPagosRepository MetogoPagosRepository;
   private ModelprodsRepository ModelprodsRepository;
   private ModelsRepository ModelsRepository;
   private ModificaImpuestossRepository ModificaImpuestossRepository;
   private MoninvensRepository MoninvensRepository;
   private MovimientosAsientossRepository MovimientosAsientossRepository;
   private MovimientosPagossRepository MovimientosPagossRepository;
   private OrdssRepository OrdssRepository;
   private PartcomprsRepository PartcomprsRepository;
   private PartcomprssRepository PartcomprssRepository;
   private PartcomprsTmpsRepository PartcomprsTmpsRepository;
   private PartcotsRepository PartcotsRepository;
   private PartflujactsRepository PartflujactsRepository;
   private PartordssRepository PartordssRepository;
   private PartprevcomprssRepository PartprevcomprssRepository;
   private PartprevcomprsTmpsRepository PartprevcomprsTmpsRepository;
   private PartvtaRepository PartvtaRepository;   
   private PaymentFormsRepository PaymentFormsRepository;
   private PaymentsRepository PaymentsRepository;
   private PedidosPartssRepository PedidosPartssRepository;
   private PedidosRepository PedidosRepository;
   private PedidossRepository PedidossRepository;
   private PerssRepository PerssRepository;
   private PessRepository PessRepository;
   private PrevcomprssRepository PrevcomprssRepository;
   private ProdpartsRepository ProdpartsRepository;
   private ProductsRepository ProductsRepository;
   private PushNotificationsRepository PushNotificationsRepository;
   private RegistroemailsRepository RegistroemailsRepository;
   private ResplogsRepository ResplogsRepository;
   private ResponsablesRepository ResponsablesRepository;
   private RubrsRepository RubrsRepository;
   private SalessRepository SalessRepository;
   private SectoressRepository SectoressRepository;
   private SerieprodsRepository SerieprodsRepository;
   private SerieRepository SerieRepository;
   private SeriesRepository SeriesRepository;
   private ServerSessionRepository ServerSessionRepository;
   private ServerSessionsRepository ServerSessionsRepository;
   private SubramossRepository SubramossRepository;
   private SucursalsRepository SucursalsRepository;
   private SuppliersRepository SuppliersRepository;
   private TarssRepository TarssRepository;
   private TaxesRepository TaxesRepository;   
   private TermarcamodelosRepository TermarcamodelosRepository;
   private TerprodcompasRepository TerprodcompasRepository;
   private TipactfijsRepository TipactfijsRepository;
   private TipscambsRepository TipscambsRepository;
   private TipsRepository TipsRepository;
   private TipssRepository TipssRepository;
   private TraspassRepository TraspassRepository;
   private UnidsRepository UnidsRepository;
   private UserPermissionsRepository UserPermissionsRepository;
   private UsersRepository UsersRepository;   
   private UsuarioseriesRepository UsuarioseriesRepository;
   private WarehousesRepository WarehousesRepository;
   private ZonasRepository ZonasRepository;

   private RepositoryFactory(){
   }

   final public static RepositoryFactory getInstance(){
       LoggerUtility.getSingleton().logInfo(RepositoryFactory.class, "Hibernate: Getting instance repository manager");
       if(RepositoryFactory==null){
           RepositoryFactory = new RepositoryFactory();
       }
       return RepositoryFactory;
   }

   public ActfijcatsRepository getActfijcatsRepository() {
       if(ActfijcatsRepository==null){ActfijcatsRepository = new ActfijcatsRepository();}return ActfijcatsRepository;
   }
   public ActfijsRepository getActfijsRepository() {
       if(ActfijsRepository==null){ActfijsRepository = new ActfijsRepository();}return ActfijsRepository;
   }
   public ActivossRepository getActivossRepository() {
       if(ActivossRepository==null){ActivossRepository = new ActivossRepository();}return ActivossRepository;
   }
   public AduanasRepository getAduanasRepository() {
       if(AduanasRepository==null){AduanasRepository = new AduanasRepository();}return AduanasRepository;
   }
   public AnaqssRepository getAnaqssRepository() {
       if(AnaqssRepository==null){AnaqssRepository = new AnaqssRepository();}return AnaqssRepository;
   }
   public AsientosContablessRepository getAsientosContablessRepository() {
       if(AsientosContablessRepository==null){AsientosContablessRepository = new AsientosContablessRepository();}return AsientosContablessRepository;
   }
   public AsocdescsRepository getAsocdescsRepository() {
       if(AsocdescsRepository==null){AsocdescsRepository = new AsocdescsRepository();}return AsocdescsRepository;
   }
   public AuxiliarsRepository getAuxiliarsRepository() {
       if(AuxiliarsRepository==null){AuxiliarsRepository = new AuxiliarsRepository();}return AuxiliarsRepository;
   }
   public BancosRepository getBancosRepository() {
       if(BancosRepository==null){BancosRepository = new BancosRepository();}return BancosRepository;
   }
   public BasDatssRepository getBasDatssRepository() {
       if(BasDatssRepository==null){BasDatssRepository = new BasDatssRepository();}return BasDatssRepository;
   }
   public CAduanasRepository getCAduanasRepository() {
       if(CAduanasRepository==null){CAduanasRepository = new CAduanasRepository();}return CAduanasRepository;
   }
   public CClaveprodservsRepository getCClaveprodservsRepository() {
       if(CClaveprodservsRepository==null){CClaveprodservsRepository = new CClaveprodservsRepository();}return CClaveprodservsRepository;
   }
   public CClaveUnidadsRepository getCClaveUnidadsRepository() {
       if(CClaveUnidadsRepository==null){CClaveUnidadsRepository = new CClaveUnidadsRepository();}return CClaveUnidadsRepository;
   }
   public CCodigoPostalRepository getCCodigoPostalRepository() {
       if(CCodigoPostalRepository==null){CCodigoPostalRepository = new CCodigoPostalRepository();}return CCodigoPostalRepository;
   }
   public CCoinsRepository getCCoinsRepository() {
       if(CCoinsRepository==null){CCoinsRepository = new CCoinsRepository();}return CCoinsRepository;
   }
   public CCountriesRepository getCCountriesRepository() {
       if(CCountriesRepository==null){CCountriesRepository = new CCountriesRepository();}return CCountriesRepository;
   }
   public CFDIRelacionadosPagosRepository getCFDIRelacionadosPagosRepository() {
       if(CFDIRelacionadosPagosRepository==null){CFDIRelacionadosPagosRepository = new CFDIRelacionadosPagosRepository();}return CFDIRelacionadosPagosRepository;
   }
   public ClasificacionsRepository getClasificacionsRepository() {
       if(ClasificacionsRepository==null){ClasificacionsRepository = new ClasificacionsRepository();}return ClasificacionsRepository;
   }
   public CoinsRepository getCoinsRepository() {
       if(CoinsRepository==null){CoinsRepository = new CoinsRepository();}return CoinsRepository;
   }
   public CompanysRepository getCompanysRepository() {
       if(CompanysRepository==null){CompanysRepository = new CompanysRepository();}return CompanysRepository;
   }
   public CompasRepository getCompasRepository() {
       if(CompasRepository==null){CompasRepository = new CompasRepository();}return CompasRepository;
   }
   public ComprsRepository getComprsRepository() {
       if(ComprsRepository==null){ComprsRepository = new ComprsRepository();}return ComprsRepository;
   }
   public ComprssRepository getComprssRepository() {
       if(ComprssRepository==null){ComprssRepository = new ComprssRepository();}return ComprssRepository;
   }
   public ComprsTmpsRepository getComprsTmpsRepository() {
       if(ComprsTmpsRepository==null){ComprsTmpsRepository = new ComprsTmpsRepository();}return ComprsTmpsRepository;
   }
   public ConcepnotsRepository getConcepnotsRepository() {
       if(ConcepnotsRepository==null){ConcepnotsRepository = new ConcepnotsRepository();}return ConcepnotsRepository;
   }
   public ConceppagsRepository getConceppagsRepository() {
       if(ConceppagsRepository==null){ConceppagsRepository = new ConceppagsRepository();}return ConceppagsRepository;
   }
   public ConcepssRepository getConcepssRepository() {
       if(ConcepssRepository==null){ConcepssRepository = new ConcepssRepository();}return ConcepssRepository;
   }
   public ConfgralRepository getConfgralRepository() {
       if(ConfgralRepository==null){ConfgralRepository = new ConfgralRepository();}return ConfgralRepository;
   }
   public ConsecsRepository getConsecsRepository() {
       if(ConsecsRepository==null){ConsecsRepository = new ConsecsRepository();}return ConsecsRepository;
   }
   public ControlexportarsRepository getControlexportarsRepository() {
       if(ControlexportarsRepository==null){ControlexportarsRepository = new ControlexportarsRepository();}return ControlexportarsRepository;
   }
   public CorreoTerminalsRepository getCorreoTerminalsRepository() {
       if(CorreoTerminalsRepository==null){CorreoTerminalsRepository = new CorreoTerminalsRepository();}return CorreoTerminalsRepository;
   }
   public CorrselecRepository getCorrselecRepository() {
       if(CorrselecRepository==null){CorrselecRepository = new CorrselecRepository();}return CorrselecRepository;
   }
   public CorrselecsRepository getCorrselecsRepository() {
       if(CorrselecsRepository==null){CorrselecsRepository = new CorrselecsRepository();}return CorrselecsRepository;
   }
   public CortessRepository getCortessRepository() {
       if(CortessRepository==null){CortessRepository = new CortessRepository();}return CortessRepository;
   }
   public CortszxsRepository getCortszxsRepository() {
       if(CortszxsRepository==null){CortszxsRepository = new CortszxsRepository();}return CortszxsRepository;
   }
   public CostssRepository getCostssRepository() {
       if(CostssRepository==null){CostssRepository = new CostssRepository();}return CostssRepository;
   }
   public CotssRepository getCotssRepository() {
       if(CotssRepository==null){CotssRepository = new CotssRepository();}return CotssRepository;
   }
   public CountriesRepository getCountriesRepository() {
       if(CountriesRepository==null){CountriesRepository = new CountriesRepository();}return CountriesRepository;
   }
   public CPaymentFormsRepository getCPaymentFormsRepository() {
       if(CPaymentFormsRepository==null){CPaymentFormsRepository = new CPaymentFormsRepository();}return CPaymentFormsRepository;
   }
   public CPaymentMethodsRepository getCPaymentMethodsRepository() {
       if(CPaymentMethodsRepository==null){CPaymentMethodsRepository = new CPaymentMethodsRepository();}return CPaymentMethodsRepository;
   }
   public CRegimenFiscalRepository getCRegimenFiscalRepository() {
       if(CRegimenFiscalRepository==null){CRegimenFiscalRepository = new CRegimenFiscalRepository();}return CRegimenFiscalRepository;
   }
   public CTipoComprobantesRepository getCTipoComprobantesRepository() {
       if(CTipoComprobantesRepository==null){CTipoComprobantesRepository = new CTipoComprobantesRepository();}return CTipoComprobantesRepository;
   }
   public CTipoRelacionsRepository getCTipoRelacionsRepository() {
       if(CTipoRelacionsRepository==null){CTipoRelacionsRepository = new CTipoRelacionsRepository();}return CTipoRelacionsRepository;
   }
   public CuentasContablesRepository getCuentasContablesRepository() {
       if(CuentasContablesRepository==null){CuentasContablesRepository = new CuentasContablesRepository();}return CuentasContablesRepository;
   }
   public CuentasContablessRepository getCuentasContablessRepository() {
       if(CuentasContablessRepository==null){CuentasContablessRepository = new CuentasContablessRepository();}return CuentasContablessRepository;
   }
   public CUsoCFDIsRepository getCUsoCFDIsRepository() {
       if(CUsoCFDIsRepository==null){CUsoCFDIsRepository = new CUsoCFDIsRepository();}return CUsoCFDIsRepository;
   }
   public CxcRepository getCxcRepository() {
       if(CxcRepository==null){CxcRepository = new CxcRepository();}return CxcRepository;
   }
   public CxcsRepository getCxcsRepository() {
       if(CxcsRepository==null){CxcsRepository = new CxcsRepository();}return CxcsRepository;
   }
   public CxpRepository getCxpRepository() {
       if(CxpRepository==null){CxpRepository = new CxpRepository();}return CxpRepository;
   }
   public CxpsRepository getCxpsRepository() {
       if(CxpsRepository==null){CxpsRepository = new CxpsRepository();}return CxpsRepository;
   }
   public DatoscpsRepository getDatoscpsRepository() {
       if(DatoscpsRepository==null){DatoscpsRepository = new DatoscpsRepository();}return DatoscpsRepository;
   }
   public DocumentOriginRepository getDocumentOriginRepository() {
       if(DocumentOriginRepository==null){DocumentOriginRepository = new DocumentOriginRepository();}return DocumentOriginRepository;
   }
   public DocumentosContabilizadossRepository getDocumentosContabilizadossRepository() {
       if(DocumentosContabilizadossRepository==null){DocumentosContabilizadossRepository = new DocumentosContabilizadossRepository();}return DocumentosContabilizadossRepository;
   }
   public DocumentosOrigensRepository getDocumentosOrigensRepository() {
       if(DocumentosOrigensRepository==null){DocumentosOrigensRepository = new DocumentosOrigensRepository();}return DocumentosOrigensRepository;
   }
   public DocumentosPagosRepository getDocumentosPagosRepository() {
       if(DocumentosPagosRepository==null){DocumentosPagosRepository = new DocumentosPagosRepository();}return DocumentosPagosRepository;
   }
   public EREjerciciossRepository getEREjerciciossRepository() {
       if(EREjerciciossRepository==null){EREjerciciossRepository = new EREjerciciossRepository();}return EREjerciciossRepository;
   }
   public ERMmovimientosInventariosRepository getERMmovimientosInventariosRepository() {
       if(ERMmovimientosInventariosRepository==null){ERMmovimientosInventariosRepository = new ERMmovimientosInventariosRepository();}return ERMmovimientosInventariosRepository;
   }
   public ERPermisosRepository getERPermisosRepository() {
       if(ERPermisosRepository==null){ERPermisosRepository = new ERPermisosRepository();}return ERPermisosRepository;
   }
   public ERPermisossRepository getERPermisossRepository() {
       if(ERPermisossRepository==null){ERPermisossRepository = new ERPermisossRepository();}return ERPermisossRepository;
   }
   public ExistalmasRepository getExistalmasRepository() {
       if(ExistalmasRepository==null){ExistalmasRepository = new ExistalmasRepository();}return ExistalmasRepository;
   }
   public FabssRepository getFabssRepository() {
       if(FabssRepository==null){FabssRepository = new FabssRepository();}return FabssRepository;
   }
   public FacturassRepository getFacturassRepository() {
       if(FacturassRepository==null){FacturassRepository = new FacturassRepository();}return FacturassRepository;
   }
   public FlujactsRepository getFlujactsRepository() {
       if(FlujactsRepository==null){FlujactsRepository = new FlujactsRepository();}return FlujactsRepository;
   }
   public FlujsRepository getFlujsRepository() {
       if(FlujsRepository==null){FlujsRepository = new FlujsRepository();}return FlujsRepository;
   }
   public GaransRepository getGaransRepository() {
       if(GaransRepository==null){GaransRepository = new GaransRepository();}return GaransRepository;
   }
   public GeneralConfigsRepository getGeneralConfigsRepository() {
       if(GeneralConfigsRepository==null){GeneralConfigsRepository = new GeneralConfigsRepository();}return GeneralConfigsRepository;
   }
   public GiroRepository getGiroRepository() {
       if(GiroRepository==null){GiroRepository = new GiroRepository();}return GiroRepository;
   }
   public GirosRepository getGirosRepository() {
       if(GirosRepository==null){GirosRepository = new GirosRepository();}return GirosRepository;
   }
   public HistAntiguedaddesaldosRepository getHistAntiguedaddesaldosRepository() {
       if(HistAntiguedaddesaldosRepository==null){HistAntiguedaddesaldosRepository = new HistAntiguedaddesaldosRepository();}return HistAntiguedaddesaldosRepository;
   }
   public ImpuestosVentasRepository getImpuestosVentasRepository() {
       if(ImpuestosVentasRepository==null){ImpuestosVentasRepository = new ImpuestosVentasRepository();}return ImpuestosVentasRepository;
   }
   public ImpuestosXComprasRepository getImpuestosXComprasRepository() {
       if(ImpuestosXComprasRepository==null){ImpuestosXComprasRepository = new ImpuestosXComprasRepository();}return ImpuestosXComprasRepository;
   }
   public ImpuestosXVentasRepository getImpuestosXVentasRepository() {
       if(ImpuestosXVentasRepository==null){ImpuestosXVentasRepository = new ImpuestosXVentasRepository();}return ImpuestosXVentasRepository;
   }
   public ImpuesxpartidacotsRepository getImpuesxpartidacotsRepository() {
       if(ImpuesxpartidacotsRepository==null){ImpuesxpartidacotsRepository = new ImpuesxpartidacotsRepository();}return ImpuesxpartidacotsRepository;
   }
   public ImpuesxpartidapedsRepository getImpuesxpartidapedsRepository() {
       if(ImpuesxpartidapedsRepository==null){ImpuesxpartidapedsRepository = new ImpuesxpartidapedsRepository();}return ImpuesxpartidapedsRepository;
   }
   public ImpuesXProductRepository getImpuesXProductRepository() {
       if(ImpuesXProductRepository==null){ImpuesXProductRepository = new ImpuesXProductRepository();}return ImpuesXProductRepository;
   }
   public IngresosEncabRepository getIngresosEncabRepository() {
       if(IngresosEncabRepository==null){IngresosEncabRepository = new IngresosEncabRepository();}return IngresosEncabRepository;
   }
   public IngresRepository getIngresRepository() {
       if(IngresRepository==null){IngresRepository = new IngresRepository();}return IngresRepository;
   }
   public KitssRepository getKitssRepository() {
       if(KitssRepository==null){KitssRepository = new KitssRepository();}return KitssRepository;
   }
   public LicensesRepository getLicensesRepository() {
       if(LicensesRepository==null){LicensesRepository = new LicensesRepository();}return LicensesRepository;
   }
   public LinesRepository getLinesRepository() {
       if(LinesRepository==null){LinesRepository = new LinesRepository();}return LinesRepository;
   }
   public LogsRepository getLogsRepository() {
       if(LogsRepository==null){LogsRepository = new LogsRepository();}return LogsRepository;
   }
   public LotpedRepository getLotpedRepository() {
       if(LotpedRepository==null){LotpedRepository = new LotpedRepository();}return LotpedRepository;
   }
   public LugssRepository getLugssRepository() {
       if(LugssRepository==null){LugssRepository = new LugssRepository();}return LugssRepository;
   }
   public MarcprodsRepository getMarcprodsRepository() {
       if(MarcprodsRepository==null){MarcprodsRepository = new MarcprodsRepository();}return MarcprodsRepository;
   }
   public MarcssRepository getMarcssRepository() {
       if(MarcssRepository==null){MarcssRepository = new MarcssRepository();}return MarcssRepository;
   }
   public MaxminconfsRepository getMaxminconfsRepository() {
       if(MaxminconfsRepository==null){MaxminconfsRepository = new MaxminconfsRepository();}return MaxminconfsRepository;
   }
   public MeasuresRepository getMeasuresRepository() {
       if(MeasuresRepository==null){MeasuresRepository = new MeasuresRepository();}return MeasuresRepository;
   }
   public MedssRepository getMedssRepository() {
       if(MedssRepository==null){MedssRepository = new MedssRepository();}return MedssRepository;
   }
   public MetogoPagosRepository getMetogoPagosRepository() {
       if(MetogoPagosRepository==null){MetogoPagosRepository = new MetogoPagosRepository();}return MetogoPagosRepository;
   }
   public ModelprodsRepository getModelprodsRepository() {
       if(ModelprodsRepository==null){ModelprodsRepository = new ModelprodsRepository();}return ModelprodsRepository;
   }
   public ModelsRepository getModelsRepository() {
       if(ModelsRepository==null){ModelsRepository = new ModelsRepository();}return ModelsRepository;
   }
   public ModificaImpuestossRepository getModificaImpuestossRepository() {
       if(ModificaImpuestossRepository==null){ModificaImpuestossRepository = new ModificaImpuestossRepository();}return ModificaImpuestossRepository;
   }
   public MoninvensRepository getMoninvensRepository() {
       if(MoninvensRepository==null){MoninvensRepository = new MoninvensRepository();}return MoninvensRepository;
   }
   public MovimientosAsientossRepository getMovimientosAsientossRepository() {
       if(MovimientosAsientossRepository==null){MovimientosAsientossRepository = new MovimientosAsientossRepository();}return MovimientosAsientossRepository;
   }
   public MovimientosPagossRepository getMovimientosPagossRepository() {
       if(MovimientosPagossRepository==null){MovimientosPagossRepository = new MovimientosPagossRepository();}return MovimientosPagossRepository;
   }
   public OrdssRepository getOrdssRepository() {
       if(OrdssRepository==null){OrdssRepository = new OrdssRepository();}return OrdssRepository;
   }
   public PartcomprsRepository getPartcomprsRepository() {
       if(PartcomprsRepository==null){PartcomprsRepository = new PartcomprsRepository();}return PartcomprsRepository;
   }
   public PartcomprssRepository getPartcomprssRepository() {
       if(PartcomprssRepository==null){PartcomprssRepository = new PartcomprssRepository();}return PartcomprssRepository;
   }
   public PartcomprsTmpsRepository getPartcomprsTmpsRepository() {
       if(PartcomprsTmpsRepository==null){PartcomprsTmpsRepository = new PartcomprsTmpsRepository();}return PartcomprsTmpsRepository;
   }
   public PartcotsRepository getPartcotsRepository() {
       if(PartcotsRepository==null){PartcotsRepository = new PartcotsRepository();}return PartcotsRepository;
   }
   public PartflujactsRepository getPartflujactsRepository() {
       if(PartflujactsRepository==null){PartflujactsRepository = new PartflujactsRepository();}return PartflujactsRepository;
   }
   public PartordssRepository getPartordssRepository() {
       if(PartordssRepository==null){PartordssRepository = new PartordssRepository();}return PartordssRepository;
   }
   public PartprevcomprssRepository getPartprevcomprssRepository() {
       if(PartprevcomprssRepository==null){PartprevcomprssRepository = new PartprevcomprssRepository();}return PartprevcomprssRepository;
   }
   public PartprevcomprsTmpsRepository getPartprevcomprsTmpsRepository() {
       if(PartprevcomprsTmpsRepository==null){PartprevcomprsTmpsRepository = new PartprevcomprsTmpsRepository();}return PartprevcomprsTmpsRepository;
   }
   public PartvtaRepository getPartvtaRepository() {
       if(PartvtaRepository==null){PartvtaRepository = new PartvtaRepository();}return PartvtaRepository;
   }
   public PaymentFormsRepository getPaymentFormsRepository() {
       if(PaymentFormsRepository==null){PaymentFormsRepository = new PaymentFormsRepository();}return PaymentFormsRepository;
   }
   public PaymentsRepository getPaymentsRepository() {
       if(PaymentsRepository==null){PaymentsRepository = new PaymentsRepository();}return PaymentsRepository;
   }
   public PedidosPartssRepository getPedidosPartssRepository() {
       if(PedidosPartssRepository==null){PedidosPartssRepository = new PedidosPartssRepository();}return PedidosPartssRepository;
   }
   public PedidosRepository getPedidosRepository() {
       if(PedidosRepository==null){PedidosRepository = new PedidosRepository();}return PedidosRepository;
   }
   public PedidossRepository getPedidossRepository() {
       if(PedidossRepository==null){PedidossRepository = new PedidossRepository();}return PedidossRepository;
   }
   public PerssRepository getPerssRepository() {
       if(PerssRepository==null){PerssRepository = new PerssRepository();}return PerssRepository;
   }
   public PessRepository getPessRepository() {
       if(PessRepository==null){PessRepository = new PessRepository();}return PessRepository;
   }
   public PrevcomprssRepository getPrevcomprssRepository() {
       if(PrevcomprssRepository==null){PrevcomprssRepository = new PrevcomprssRepository();}return PrevcomprssRepository;
   }
   public ProdpartsRepository getProdpartsRepository() {
       if(ProdpartsRepository==null){ProdpartsRepository = new ProdpartsRepository();}return ProdpartsRepository;
   }
   public ProductsRepository getProductsRepository() {
       if(ProductsRepository==null){ProductsRepository = new ProductsRepository();}return ProductsRepository;
   }
   public PushNotificationsRepository getPushNotificationsRepository() {
       if(PushNotificationsRepository==null){PushNotificationsRepository = new PushNotificationsRepository();}return PushNotificationsRepository;
   }
   public RegistroemailsRepository getRegistroemailsRepository() {
       if(RegistroemailsRepository==null){RegistroemailsRepository = new RegistroemailsRepository();}return RegistroemailsRepository;
   }
   public ResplogsRepository getResplogsRepository() {
       if(ResplogsRepository==null){ResplogsRepository = new ResplogsRepository();}return ResplogsRepository;
   }
   public ResponsablesRepository getResponsablesRepository() {
       if(ResponsablesRepository==null){ResponsablesRepository = new ResponsablesRepository();}return ResponsablesRepository;
   }
   public RubrsRepository getRubrsRepository() {
       if(RubrsRepository==null){RubrsRepository = new RubrsRepository();}return RubrsRepository;
   }
   public SalessRepository getSalessRepository() {
       if(SalessRepository==null){SalessRepository = new SalessRepository();}return SalessRepository;
   }
   public SectoressRepository getSectoressRepository() {
       if(SectoressRepository==null){SectoressRepository = new SectoressRepository();}return SectoressRepository;
   }
   public SerieprodsRepository getSerieprodsRepository() {
       if(SerieprodsRepository==null){SerieprodsRepository = new SerieprodsRepository();}return SerieprodsRepository;
   }
   public SerieRepository getSerieRepository() {
       if(SerieRepository==null){SerieRepository = new SerieRepository();}return SerieRepository;
   }
   public SeriesRepository getSeriesRepository() {
       if(SeriesRepository==null){SeriesRepository = new SeriesRepository();}return SeriesRepository;
   }
   public ServerSessionRepository getServerSessionRepository() {
       if(ServerSessionRepository==null){ServerSessionRepository = new ServerSessionRepository();}return ServerSessionRepository;
   }
   public ServerSessionsRepository getServerSessionsRepository() {
       if(ServerSessionsRepository==null){ServerSessionsRepository = new ServerSessionsRepository();}return ServerSessionsRepository;
   }
   public SubramossRepository getSubramossRepository() {
       if(SubramossRepository==null){SubramossRepository = new SubramossRepository();}return SubramossRepository;
   }
   public SucursalsRepository getSucursalsRepository() {
       if(SucursalsRepository==null){SucursalsRepository = new SucursalsRepository();}return SucursalsRepository;
   }
   public SuppliersRepository getSuppliersRepository() {
       if(SuppliersRepository==null){SuppliersRepository = new SuppliersRepository();}return SuppliersRepository;
   }
   public TarssRepository getTarssRepository() {
       if(TarssRepository==null){TarssRepository = new TarssRepository();}return TarssRepository;
   }
   public TaxesRepository getTaxesRepository() {
       if(TaxesRepository==null){TaxesRepository = new TaxesRepository();}return TaxesRepository;
   }
   public TermarcamodelosRepository getTermarcamodelosRepository() {
       if(TermarcamodelosRepository==null){TermarcamodelosRepository = new TermarcamodelosRepository();}return TermarcamodelosRepository;
   }
   public TerprodcompasRepository getTerprodcompasRepository() {
       if(TerprodcompasRepository==null){TerprodcompasRepository = new TerprodcompasRepository();}return TerprodcompasRepository;
   }
   public TipactfijsRepository getTipactfijsRepository() {
       if(TipactfijsRepository==null){TipactfijsRepository = new TipactfijsRepository();}return TipactfijsRepository;
   }
   public TipscambsRepository getTipscambsRepository() {
       if(TipscambsRepository==null){TipscambsRepository = new TipscambsRepository();}return TipscambsRepository;
   }
   public TipsRepository getTipsRepository() {
       if(TipsRepository==null){TipsRepository = new TipsRepository();}return TipsRepository;
   }
   public TipssRepository getTipssRepository() {
       if(TipssRepository==null){TipssRepository = new TipssRepository();}return TipssRepository;
   }
   public TraspassRepository getTraspassRepository() {
       if(TraspassRepository==null){TraspassRepository = new TraspassRepository();}return TraspassRepository;
   }
   public UnidsRepository getUnidsRepository() {
       if(UnidsRepository==null){UnidsRepository = new UnidsRepository();}return UnidsRepository;
   }
   public UserPermissionsRepository getUserPermissionsRepository() {
       if(UserPermissionsRepository==null){UserPermissionsRepository = new UserPermissionsRepository();}return UserPermissionsRepository;
   }
   public UsersRepository getUsersRepository() {
       if(UsersRepository==null){UsersRepository = new UsersRepository();}return UsersRepository;
   }
   public UsuarioseriesRepository getUsuarioseriesRepository() {
       if(UsuarioseriesRepository==null){UsuarioseriesRepository = new UsuarioseriesRepository();}return UsuarioseriesRepository;
   }
   public WarehousesRepository getWarehousesRepository() {
       if(WarehousesRepository==null){WarehousesRepository = new WarehousesRepository();}return WarehousesRepository;
   }
   public ZonasRepository getZonasRepository() {
       if(ZonasRepository==null){ZonasRepository = new ZonasRepository();}return ZonasRepository;
   }
   
   public PaymentsSalesRepository getPaymentsSalesRepository(){       
       if(PaymentsSalesRepository==null){PaymentsSalesRepository = new PaymentsSalesRepository();}return PaymentsSalesRepository;
   }
}