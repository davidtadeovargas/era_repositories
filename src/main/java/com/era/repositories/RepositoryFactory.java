package com.era.repositories;

import com.era.logger.LoggerUtility;

public class RepositoryFactory {

   private static RepositoryFactory RepositoryFactory;

   private CompanysRepository CompanysRepository;
   private CTipoRelacionsRepository CTipoRelacionsRepository;
   private CTipoComprobantesRepository CTipoComprobantesRepository;
   private CPaymentMethodsRepository CPaymentMethodsRepository;
   private CPaymentFormsRepository CPaymentFormsRepository;
   private CFDIRelacionadosPagosRepository CFDIRelacionadosPagosRepository;
   private CCoinsRepository CCoinsRepository;
   private CClaveprodservsRepository CClaveprodservsRepository;
   private CClaveUnidadsRepository CClaveUnidadsRepository;
   private CAduanasRepository CAduanasRepository;
   private BasDatssRepository BasDatssRepository;
   private BancosRepository BancosRepository;
   private AuxiliarsRepository AuxiliarsRepository;
   private AsocdescsRepository AsocdescsRepository;
   private AsientosContablessRepository AsientosContablessRepository;
   private AnaqssRepository AnaqssRepository;
   private AduanasRepository AduanasRepository;
   private ActivossRepository ActivossRepository;
   private ActfijcatsRepository ActfijcatsRepository;
   private ActfijsRepository ActfijsRepository;
   private CortszxsRepository CortszxsRepository;
   private CortessRepository CortessRepository;
   private CorrselecsRepository CorrselecsRepository;
   private CorreoTerminalsRepository CorreoTerminalsRepository;
   private ControlexportarsRepository ControlexportarsRepository;
   private ContrassRepository ContrassRepository;
   private ConsecsRepository ConsecsRepository;
   private ConfgralsRepository ConfgralsRepository;
   private ConcepssRepository ConcepssRepository;
   private ConceppagsRepository ConceppagsRepository;
   private ConcepnotsRepository ConcepnotsRepository;
   private ComprsTmpsRepository ComprsTmpsRepository;
   private ComprssRepository ComprssRepository;
   private CompasRepository CompasRepository;
   private ColossRepository ColossRepository;
   private CoinsRepository CoinsRepository;
   private ClasprovsRepository ClasprovsRepository;
   private ClasprodsRepository ClasprodsRepository;
   private ClasjeraprovsRepository ClasjeraprovsRepository;
   private ClasjeraprodsRepository ClasjeraprodsRepository;
   private ClasjeraclisRepository ClasjeraclisRepository;
   private ClasificacionsRepository ClasificacionsRepository;
   private ClasempsRepository ClasempsRepository;
   private ChatsRepository ChatsRepository;
   private CUsoCFDIsRepository CUsoCFDIsRepository;
   private GeneralConfigsRepository GeneralConfigsRepository;
   private GaransRepository GaransRepository;
   private FlujactsRepository FlujactsRepository;
   private FlujsRepository FlujsRepository;
   private FacturassRepository FacturassRepository;
   private FabssRepository FabssRepository;
   private ExistalmasRepository ExistalmasRepository;
   private EstadiscorsRepository EstadiscorsRepository;
   private ERPermisossRepository ERPermisossRepository;
   private ERMmovimientosInventariosRepository ERMmovimientosInventariosRepository;
   private EREjerciciossRepository EREjerciciossRepository;
   private DomentclisRepository DomentclisRepository;
   private DocumentosPagosRepository DocumentosPagosRepository;
   private DocumentosOrigensRepository DocumentosOrigensRepository;
   private DocumentosContabilizadossRepository DocumentosContabilizadossRepository;
   private DocumentOriginsRepository DocumentOriginsRepository;
   private DeliverAddressCustomersRepository DeliverAddressCustomersRepository;
   private DatoscpsRepository DatoscpsRepository;
   private CxpsRepository CxpsRepository;
   private CxcsRepository CxcsRepository;
   private CumplesRepository CumplesRepository;
   private CuentasContablessRepository CuentasContablessRepository;
   private CotssRepository CotssRepository;
   private CostssRepository CostssRepository;
   private PartcomprsTmpsRepository PartcomprsTmpsRepository;
   private PartcomprssRepository PartcomprssRepository;
   private OrdssRepository OrdssRepository;
   private MsjssRepository MsjssRepository;
   private MovimientosPagossRepository MovimientosPagossRepository;
   private MovimientosAsientossRepository MovimientosAsientossRepository;
   private MoninvensRepository MoninvensRepository;
   private ModificaImpuestossRepository ModificaImpuestossRepository;
   private ModelprodsRepository ModelprodsRepository;
   private ModelsRepository ModelsRepository;
   private MetogoPagosRepository MetogoPagosRepository;
   private MedssRepository MedssRepository;
   private MeasuresRepository MeasuresRepository;
   private MaxminconfsRepository MaxminconfsRepository;
   private MarcssRepository MarcssRepository;
   private MarcprodsRepository MarcprodsRepository;
   private LugssRepository LugssRepository;
   private LogsRepository LogsRepository;
   private LinesRepository LinesRepository;
   private LicensesRepository LicensesRepository;
   private KitssRepository KitssRepository;
   private IngresosEncabsRepository IngresosEncabsRepository;
   private IngressRepository IngressRepository;
   private ImpuesxpartidapedsRepository ImpuesxpartidapedsRepository;
   private ImpuesxpartidacotsRepository ImpuesxpartidacotsRepository;
   private ImpuestosXVentasRepository ImpuestosXVentasRepository;
   private ImpuestosXComprasRepository ImpuestosXComprasRepository;
   private ImpuestosVentasRepository ImpuestosVentasRepository;
   private ImpuesXProductsRepository ImpuesXProductsRepository;
   private HistAntiguedaddesaldosRepository HistAntiguedaddesaldosRepository;
   private GralssRepository GralssRepository;
   private GirosRepository GirosRepository;
   private resp355834sRepository resp355834sRepository;
   private ZonasRepository ZonasRepository;
   private WarehousesRepository WarehousesRepository;
   private UsuarioseriesRepository UsuarioseriesRepository;
   private UsoCFDIsRepository UsoCFDIsRepository;
   private UserPermissionsRepository UserPermissionsRepository;
   private UsersRepository UsersRepository;
   private UnidsRepository UnidsRepository;
   private UbiadsRepository UbiadsRepository;
   private TraspassRepository TraspassRepository;
   private TipscambsRepository TipscambsRepository;
   private TipssRepository TipssRepository;
   private TipactfijsRepository TipactfijsRepository;
   private TerprodcompasRepository TerprodcompasRepository;
   private TermarcamodelosRepository TermarcamodelosRepository;
   private TaxsRepository TaxsRepository;
   private TarssRepository TarssRepository;
   private TallcolosRepository TallcolosRepository;
   private TallsRepository TallsRepository;
   private SuppliersRepository SuppliersRepository;
   private SucursalsRepository SucursalsRepository;
   private SubramossRepository SubramossRepository;
   private ServerSessionsRepository ServerSessionsRepository;
   private SerieprodsRepository SerieprodsRepository;
   private SeriesRepository SeriesRepository;
   private SectoressRepository SectoressRepository;
   private SalessRepository SalessRepository;
   private RutssRepository RutssRepository;
   private RubrsRepository RubrsRepository;
   private ResponsablesRepository ResponsablesRepository;
   private ResplogsRepository ResplogsRepository;
   private RespsRepository RespsRepository;
   private RegistrossRepository RegistrossRepository;
   private RegistroemailsRepository RegistroemailsRepository;
   private PushNotificationsRepository PushNotificationsRepository;
   private ProductsRepository ProductsRepository;
   private ProdpartsRepository ProdpartsRepository;
   private PrevcomprssRepository PrevcomprssRepository;
   private PetissRepository PetissRepository;
   private PessRepository PessRepository;
   private PerssRepository PerssRepository;
   private PedidosPartssRepository PedidosPartssRepository;
   private PedidossRepository PedidossRepository;
   private PaymentFormsRepository PaymentFormsRepository;
   private PaymentsRepository PaymentsRepository;
   private PartvtasRepository PartvtasRepository;
   private PartprevcomprsTmpsRepository PartprevcomprsTmpsRepository;
   private PartprevcomprssRepository PartprevcomprssRepository;
   private PartordssRepository PartordssRepository;
   private PartflujactsRepository PartflujactsRepository;
   private PartcotsRepository PartcotsRepository;

   private RepositoryFactory(){
   }

   final public static RepositoryFactory getInstance(){
       LoggerUtility.getSingleton().logInfo(RepositoryFactory.class, "Hibernate: Getting instance repository manager");
       if(RepositoryFactory==null){
           RepositoryFactory = new RepositoryFactory();
       }
       return RepositoryFactory;
   }

   public CompanysRepository getCompanysRepository() {
       if(CompanysRepository==null){CompanysRepository = new CompanysRepository();}return CompanysRepository;
   }
   public CTipoRelacionsRepository getCTipoRelacionsRepository() {
       if(CTipoRelacionsRepository==null){CTipoRelacionsRepository = new CTipoRelacionsRepository();}return CTipoRelacionsRepository;
   }
   public CTipoComprobantesRepository getCTipoComprobantesRepository() {
       if(CTipoComprobantesRepository==null){CTipoComprobantesRepository = new CTipoComprobantesRepository();}return CTipoComprobantesRepository;
   }
   public CPaymentMethodsRepository getCPaymentMethodsRepository() {
       if(CPaymentMethodsRepository==null){CPaymentMethodsRepository = new CPaymentMethodsRepository();}return CPaymentMethodsRepository;
   }
   public CPaymentFormsRepository getCPaymentFormsRepository() {
       if(CPaymentFormsRepository==null){CPaymentFormsRepository = new CPaymentFormsRepository();}return CPaymentFormsRepository;
   }
   public CFDIRelacionadosPagosRepository getCFDIRelacionadosPagosRepository() {
       if(CFDIRelacionadosPagosRepository==null){CFDIRelacionadosPagosRepository = new CFDIRelacionadosPagosRepository();}return CFDIRelacionadosPagosRepository;
   }
   public CCoinsRepository getCCoinsRepository() {
       if(CCoinsRepository==null){CCoinsRepository = new CCoinsRepository();}return CCoinsRepository;
   }
   public CClaveprodservsRepository getCClaveprodservsRepository() {
       if(CClaveprodservsRepository==null){CClaveprodservsRepository = new CClaveprodservsRepository();}return CClaveprodservsRepository;
   }
   public CClaveUnidadsRepository getCClaveUnidadsRepository() {
       if(CClaveUnidadsRepository==null){CClaveUnidadsRepository = new CClaveUnidadsRepository();}return CClaveUnidadsRepository;
   }
   public CAduanasRepository getCAduanasRepository() {
       if(CAduanasRepository==null){CAduanasRepository = new CAduanasRepository();}return CAduanasRepository;
   }
   public BasDatssRepository getBasDatssRepository() {
       if(BasDatssRepository==null){BasDatssRepository = new BasDatssRepository();}return BasDatssRepository;
   }
   public BancosRepository getBancosRepository() {
       if(BancosRepository==null){BancosRepository = new BancosRepository();}return BancosRepository;
   }
   public AuxiliarsRepository getAuxiliarsRepository() {
       if(AuxiliarsRepository==null){AuxiliarsRepository = new AuxiliarsRepository();}return AuxiliarsRepository;
   }
   public AsocdescsRepository getAsocdescsRepository() {
       if(AsocdescsRepository==null){AsocdescsRepository = new AsocdescsRepository();}return AsocdescsRepository;
   }
   public AsientosContablessRepository getAsientosContablessRepository() {
       if(AsientosContablessRepository==null){AsientosContablessRepository = new AsientosContablessRepository();}return AsientosContablessRepository;
   }
   public AnaqssRepository getAnaqssRepository() {
       if(AnaqssRepository==null){AnaqssRepository = new AnaqssRepository();}return AnaqssRepository;
   }
   public AduanasRepository getAduanasRepository() {
       if(AduanasRepository==null){AduanasRepository = new AduanasRepository();}return AduanasRepository;
   }
   public ActivossRepository getActivossRepository() {
       if(ActivossRepository==null){ActivossRepository = new ActivossRepository();}return ActivossRepository;
   }
   public ActfijcatsRepository getActfijcatsRepository() {
       if(ActfijcatsRepository==null){ActfijcatsRepository = new ActfijcatsRepository();}return ActfijcatsRepository;
   }
   public ActfijsRepository getActfijsRepository() {
       if(ActfijsRepository==null){ActfijsRepository = new ActfijsRepository();}return ActfijsRepository;
   }
   public CortszxsRepository getCortszxsRepository() {
       if(CortszxsRepository==null){CortszxsRepository = new CortszxsRepository();}return CortszxsRepository;
   }
   public CortessRepository getCortessRepository() {
       if(CortessRepository==null){CortessRepository = new CortessRepository();}return CortessRepository;
   }
   public CorrselecsRepository getCorrselecsRepository() {
       if(CorrselecsRepository==null){CorrselecsRepository = new CorrselecsRepository();}return CorrselecsRepository;
   }
   public CorreoTerminalsRepository getCorreoTerminalsRepository() {
       if(CorreoTerminalsRepository==null){CorreoTerminalsRepository = new CorreoTerminalsRepository();}return CorreoTerminalsRepository;
   }
   public ControlexportarsRepository getControlexportarsRepository() {
       if(ControlexportarsRepository==null){ControlexportarsRepository = new ControlexportarsRepository();}return ControlexportarsRepository;
   }
   public ContrassRepository getContrassRepository() {
       if(ContrassRepository==null){ContrassRepository = new ContrassRepository();}return ContrassRepository;
   }
   public ConsecsRepository getConsecsRepository() {
       if(ConsecsRepository==null){ConsecsRepository = new ConsecsRepository();}return ConsecsRepository;
   }
   public ConfgralsRepository getConfgralsRepository() {
       if(ConfgralsRepository==null){ConfgralsRepository = new ConfgralsRepository();}return ConfgralsRepository;
   }
   public ConcepssRepository getConcepssRepository() {
       if(ConcepssRepository==null){ConcepssRepository = new ConcepssRepository();}return ConcepssRepository;
   }
   public ConceppagsRepository getConceppagsRepository() {
       if(ConceppagsRepository==null){ConceppagsRepository = new ConceppagsRepository();}return ConceppagsRepository;
   }
   public ConcepnotsRepository getConcepnotsRepository() {
       if(ConcepnotsRepository==null){ConcepnotsRepository = new ConcepnotsRepository();}return ConcepnotsRepository;
   }
   public ComprsTmpsRepository getComprsTmpsRepository() {
       if(ComprsTmpsRepository==null){ComprsTmpsRepository = new ComprsTmpsRepository();}return ComprsTmpsRepository;
   }
   public ComprssRepository getComprssRepository() {
       if(ComprssRepository==null){ComprssRepository = new ComprssRepository();}return ComprssRepository;
   }
   public CompasRepository getCompasRepository() {
       if(CompasRepository==null){CompasRepository = new CompasRepository();}return CompasRepository;
   }
   public ColossRepository getColossRepository() {
       if(ColossRepository==null){ColossRepository = new ColossRepository();}return ColossRepository;
   }
   public CoinsRepository getCoinsRepository() {
       if(CoinsRepository==null){CoinsRepository = new CoinsRepository();}return CoinsRepository;
   }
   public ClasprovsRepository getClasprovsRepository() {
       if(ClasprovsRepository==null){ClasprovsRepository = new ClasprovsRepository();}return ClasprovsRepository;
   }
   public ClasprodsRepository getClasprodsRepository() {
       if(ClasprodsRepository==null){ClasprodsRepository = new ClasprodsRepository();}return ClasprodsRepository;
   }
   public ClasjeraprovsRepository getClasjeraprovsRepository() {
       if(ClasjeraprovsRepository==null){ClasjeraprovsRepository = new ClasjeraprovsRepository();}return ClasjeraprovsRepository;
   }
   public ClasjeraprodsRepository getClasjeraprodsRepository() {
       if(ClasjeraprodsRepository==null){ClasjeraprodsRepository = new ClasjeraprodsRepository();}return ClasjeraprodsRepository;
   }
   public ClasjeraclisRepository getClasjeraclisRepository() {
       if(ClasjeraclisRepository==null){ClasjeraclisRepository = new ClasjeraclisRepository();}return ClasjeraclisRepository;
   }
   public ClasificacionsRepository getClasificacionsRepository() {
       if(ClasificacionsRepository==null){ClasificacionsRepository = new ClasificacionsRepository();}return ClasificacionsRepository;
   }
   public ClasempsRepository getClasempsRepository() {
       if(ClasempsRepository==null){ClasempsRepository = new ClasempsRepository();}return ClasempsRepository;
   }
   public ChatsRepository getChatsRepository() {
       if(ChatsRepository==null){ChatsRepository = new ChatsRepository();}return ChatsRepository;
   }
   public CUsoCFDIsRepository getCUsoCFDIsRepository() {
       if(CUsoCFDIsRepository==null){CUsoCFDIsRepository = new CUsoCFDIsRepository();}return CUsoCFDIsRepository;
   }
   public GeneralConfigsRepository getGeneralConfigsRepository() {
       if(GeneralConfigsRepository==null){GeneralConfigsRepository = new GeneralConfigsRepository();}return GeneralConfigsRepository;
   }
   public GaransRepository getGaransRepository() {
       if(GaransRepository==null){GaransRepository = new GaransRepository();}return GaransRepository;
   }
   public FlujactsRepository getFlujactsRepository() {
       if(FlujactsRepository==null){FlujactsRepository = new FlujactsRepository();}return FlujactsRepository;
   }
   public FlujsRepository getFlujsRepository() {
       if(FlujsRepository==null){FlujsRepository = new FlujsRepository();}return FlujsRepository;
   }
   public FacturassRepository getFacturassRepository() {
       if(FacturassRepository==null){FacturassRepository = new FacturassRepository();}return FacturassRepository;
   }
   public FabssRepository getFabssRepository() {
       if(FabssRepository==null){FabssRepository = new FabssRepository();}return FabssRepository;
   }
   public ExistalmasRepository getExistalmasRepository() {
       if(ExistalmasRepository==null){ExistalmasRepository = new ExistalmasRepository();}return ExistalmasRepository;
   }
   public EstadiscorsRepository getEstadiscorsRepository() {
       if(EstadiscorsRepository==null){EstadiscorsRepository = new EstadiscorsRepository();}return EstadiscorsRepository;
   }
   public ERPermisossRepository getERPermisossRepository() {
       if(ERPermisossRepository==null){ERPermisossRepository = new ERPermisossRepository();}return ERPermisossRepository;
   }
   public ERMmovimientosInventariosRepository getERMmovimientosInventariosRepository() {
       if(ERMmovimientosInventariosRepository==null){ERMmovimientosInventariosRepository = new ERMmovimientosInventariosRepository();}return ERMmovimientosInventariosRepository;
   }
   public EREjerciciossRepository getEREjerciciossRepository() {
       if(EREjerciciossRepository==null){EREjerciciossRepository = new EREjerciciossRepository();}return EREjerciciossRepository;
   }
   public DomentclisRepository getDomentclisRepository() {
       if(DomentclisRepository==null){DomentclisRepository = new DomentclisRepository();}return DomentclisRepository;
   }
   public DocumentosPagosRepository getDocumentosPagosRepository() {
       if(DocumentosPagosRepository==null){DocumentosPagosRepository = new DocumentosPagosRepository();}return DocumentosPagosRepository;
   }
   public DocumentosOrigensRepository getDocumentosOrigensRepository() {
       if(DocumentosOrigensRepository==null){DocumentosOrigensRepository = new DocumentosOrigensRepository();}return DocumentosOrigensRepository;
   }
   public DocumentosContabilizadossRepository getDocumentosContabilizadossRepository() {
       if(DocumentosContabilizadossRepository==null){DocumentosContabilizadossRepository = new DocumentosContabilizadossRepository();}return DocumentosContabilizadossRepository;
   }
   public DocumentOriginsRepository getDocumentOriginsRepository() {
       if(DocumentOriginsRepository==null){DocumentOriginsRepository = new DocumentOriginsRepository();}return DocumentOriginsRepository;
   }
   public DeliverAddressCustomersRepository getDeliverAddressCustomersRepository() {
       if(DeliverAddressCustomersRepository==null){DeliverAddressCustomersRepository = new DeliverAddressCustomersRepository();}return DeliverAddressCustomersRepository;
   }
   public DatoscpsRepository getDatoscpsRepository() {
       if(DatoscpsRepository==null){DatoscpsRepository = new DatoscpsRepository();}return DatoscpsRepository;
   }
   public CxpsRepository getCxpsRepository() {
       if(CxpsRepository==null){CxpsRepository = new CxpsRepository();}return CxpsRepository;
   }
   public CxcsRepository getCxcsRepository() {
       if(CxcsRepository==null){CxcsRepository = new CxcsRepository();}return CxcsRepository;
   }
   public CumplesRepository getCumplesRepository() {
       if(CumplesRepository==null){CumplesRepository = new CumplesRepository();}return CumplesRepository;
   }
   public CuentasContablessRepository getCuentasContablessRepository() {
       if(CuentasContablessRepository==null){CuentasContablessRepository = new CuentasContablessRepository();}return CuentasContablessRepository;
   }
   public CotssRepository getCotssRepository() {
       if(CotssRepository==null){CotssRepository = new CotssRepository();}return CotssRepository;
   }
   public CostssRepository getCostssRepository() {
       if(CostssRepository==null){CostssRepository = new CostssRepository();}return CostssRepository;
   }
   public PartcomprsTmpsRepository getPartcomprsTmpsRepository() {
       if(PartcomprsTmpsRepository==null){PartcomprsTmpsRepository = new PartcomprsTmpsRepository();}return PartcomprsTmpsRepository;
   }
   public PartcomprssRepository getPartcomprssRepository() {
       if(PartcomprssRepository==null){PartcomprssRepository = new PartcomprssRepository();}return PartcomprssRepository;
   }
   public OrdssRepository getOrdssRepository() {
       if(OrdssRepository==null){OrdssRepository = new OrdssRepository();}return OrdssRepository;
   }
   public MsjssRepository getMsjssRepository() {
       if(MsjssRepository==null){MsjssRepository = new MsjssRepository();}return MsjssRepository;
   }
   public MovimientosPagossRepository getMovimientosPagossRepository() {
       if(MovimientosPagossRepository==null){MovimientosPagossRepository = new MovimientosPagossRepository();}return MovimientosPagossRepository;
   }
   public MovimientosAsientossRepository getMovimientosAsientossRepository() {
       if(MovimientosAsientossRepository==null){MovimientosAsientossRepository = new MovimientosAsientossRepository();}return MovimientosAsientossRepository;
   }
   public MoninvensRepository getMoninvensRepository() {
       if(MoninvensRepository==null){MoninvensRepository = new MoninvensRepository();}return MoninvensRepository;
   }
   public ModificaImpuestossRepository getModificaImpuestossRepository() {
       if(ModificaImpuestossRepository==null){ModificaImpuestossRepository = new ModificaImpuestossRepository();}return ModificaImpuestossRepository;
   }
   public ModelprodsRepository getModelprodsRepository() {
       if(ModelprodsRepository==null){ModelprodsRepository = new ModelprodsRepository();}return ModelprodsRepository;
   }
   public ModelsRepository getModelsRepository() {
       if(ModelsRepository==null){ModelsRepository = new ModelsRepository();}return ModelsRepository;
   }
   public MetogoPagosRepository getMetogoPagosRepository() {
       if(MetogoPagosRepository==null){MetogoPagosRepository = new MetogoPagosRepository();}return MetogoPagosRepository;
   }
   public MedssRepository getMedssRepository() {
       if(MedssRepository==null){MedssRepository = new MedssRepository();}return MedssRepository;
   }
   public MeasuresRepository getMeasuresRepository() {
       if(MeasuresRepository==null){MeasuresRepository = new MeasuresRepository();}return MeasuresRepository;
   }
   public MaxminconfsRepository getMaxminconfsRepository() {
       if(MaxminconfsRepository==null){MaxminconfsRepository = new MaxminconfsRepository();}return MaxminconfsRepository;
   }
   public MarcssRepository getMarcssRepository() {
       if(MarcssRepository==null){MarcssRepository = new MarcssRepository();}return MarcssRepository;
   }
   public MarcprodsRepository getMarcprodsRepository() {
       if(MarcprodsRepository==null){MarcprodsRepository = new MarcprodsRepository();}return MarcprodsRepository;
   }
   public LugssRepository getLugssRepository() {
       if(LugssRepository==null){LugssRepository = new LugssRepository();}return LugssRepository;
   }
   public LogsRepository getLogsRepository() {
       if(LogsRepository==null){LogsRepository = new LogsRepository();}return LogsRepository;
   }
   public LinesRepository getLinesRepository() {
       if(LinesRepository==null){LinesRepository = new LinesRepository();}return LinesRepository;
   }
   public LicensesRepository getLicensesRepository() {
       if(LicensesRepository==null){LicensesRepository = new LicensesRepository();}return LicensesRepository;
   }
   public KitssRepository getKitssRepository() {
       if(KitssRepository==null){KitssRepository = new KitssRepository();}return KitssRepository;
   }
   public IngresosEncabsRepository getIngresosEncabsRepository() {
       if(IngresosEncabsRepository==null){IngresosEncabsRepository = new IngresosEncabsRepository();}return IngresosEncabsRepository;
   }
   public IngressRepository getIngressRepository() {
       if(IngressRepository==null){IngressRepository = new IngressRepository();}return IngressRepository;
   }
   public ImpuesxpartidapedsRepository getImpuesxpartidapedsRepository() {
       if(ImpuesxpartidapedsRepository==null){ImpuesxpartidapedsRepository = new ImpuesxpartidapedsRepository();}return ImpuesxpartidapedsRepository;
   }
   public ImpuesxpartidacotsRepository getImpuesxpartidacotsRepository() {
       if(ImpuesxpartidacotsRepository==null){ImpuesxpartidacotsRepository = new ImpuesxpartidacotsRepository();}return ImpuesxpartidacotsRepository;
   }
   public ImpuestosXVentasRepository getImpuestosXVentasRepository() {
       if(ImpuestosXVentasRepository==null){ImpuestosXVentasRepository = new ImpuestosXVentasRepository();}return ImpuestosXVentasRepository;
   }
   public ImpuestosXComprasRepository getImpuestosXComprasRepository() {
       if(ImpuestosXComprasRepository==null){ImpuestosXComprasRepository = new ImpuestosXComprasRepository();}return ImpuestosXComprasRepository;
   }
   public ImpuestosVentasRepository getImpuestosVentasRepository() {
       if(ImpuestosVentasRepository==null){ImpuestosVentasRepository = new ImpuestosVentasRepository();}return ImpuestosVentasRepository;
   }
   public ImpuesXProductsRepository getImpuesXProductsRepository() {
       if(ImpuesXProductsRepository==null){ImpuesXProductsRepository = new ImpuesXProductsRepository();}return ImpuesXProductsRepository;
   }
   public HistAntiguedaddesaldosRepository getHistAntiguedaddesaldosRepository() {
       if(HistAntiguedaddesaldosRepository==null){HistAntiguedaddesaldosRepository = new HistAntiguedaddesaldosRepository();}return HistAntiguedaddesaldosRepository;
   }
   public GralssRepository getGralssRepository() {
       if(GralssRepository==null){GralssRepository = new GralssRepository();}return GralssRepository;
   }
   public GirosRepository getGirosRepository() {
       if(GirosRepository==null){GirosRepository = new GirosRepository();}return GirosRepository;
   }
   public resp355834sRepository getresp355834sRepository() {
       if(resp355834sRepository==null){resp355834sRepository = new resp355834sRepository();}return resp355834sRepository;
   }
   public ZonasRepository getZonasRepository() {
       if(ZonasRepository==null){ZonasRepository = new ZonasRepository();}return ZonasRepository;
   }
   public WarehousesRepository getWarehousesRepository() {
       if(WarehousesRepository==null){WarehousesRepository = new WarehousesRepository();}return WarehousesRepository;
   }
   public UsuarioseriesRepository getUsuarioseriesRepository() {
       if(UsuarioseriesRepository==null){UsuarioseriesRepository = new UsuarioseriesRepository();}return UsuarioseriesRepository;
   }
   public UsoCFDIsRepository getUsoCFDIsRepository() {
       if(UsoCFDIsRepository==null){UsoCFDIsRepository = new UsoCFDIsRepository();}return UsoCFDIsRepository;
   }
   public UserPermissionsRepository getUserPermissionsRepository() {
       if(UserPermissionsRepository==null){UserPermissionsRepository = new UserPermissionsRepository();}return UserPermissionsRepository;
   }
   public UsersRepository getUsersRepository() {
       if(UsersRepository==null){UsersRepository = new UsersRepository();}return UsersRepository;
   }
   public UnidsRepository getUnidsRepository() {
       if(UnidsRepository==null){UnidsRepository = new UnidsRepository();}return UnidsRepository;
   }
   public UbiadsRepository getUbiadsRepository() {
       if(UbiadsRepository==null){UbiadsRepository = new UbiadsRepository();}return UbiadsRepository;
   }
   public TraspassRepository getTraspassRepository() {
       if(TraspassRepository==null){TraspassRepository = new TraspassRepository();}return TraspassRepository;
   }
   public TipscambsRepository getTipscambsRepository() {
       if(TipscambsRepository==null){TipscambsRepository = new TipscambsRepository();}return TipscambsRepository;
   }
   public TipssRepository getTipssRepository() {
       if(TipssRepository==null){TipssRepository = new TipssRepository();}return TipssRepository;
   }
   public TipactfijsRepository getTipactfijsRepository() {
       if(TipactfijsRepository==null){TipactfijsRepository = new TipactfijsRepository();}return TipactfijsRepository;
   }
   public TerprodcompasRepository getTerprodcompasRepository() {
       if(TerprodcompasRepository==null){TerprodcompasRepository = new TerprodcompasRepository();}return TerprodcompasRepository;
   }
   public TermarcamodelosRepository getTermarcamodelosRepository() {
       if(TermarcamodelosRepository==null){TermarcamodelosRepository = new TermarcamodelosRepository();}return TermarcamodelosRepository;
   }
   public TaxsRepository getTaxsRepository() {
       if(TaxsRepository==null){TaxsRepository = new TaxsRepository();}return TaxsRepository;
   }
   public TarssRepository getTarssRepository() {
       if(TarssRepository==null){TarssRepository = new TarssRepository();}return TarssRepository;
   }
   public TallcolosRepository getTallcolosRepository() {
       if(TallcolosRepository==null){TallcolosRepository = new TallcolosRepository();}return TallcolosRepository;
   }
   public TallsRepository getTallsRepository() {
       if(TallsRepository==null){TallsRepository = new TallsRepository();}return TallsRepository;
   }
   public SuppliersRepository getSuppliersRepository() {
       if(SuppliersRepository==null){SuppliersRepository = new SuppliersRepository();}return SuppliersRepository;
   }
   public SucursalsRepository getSucursalsRepository() {
       if(SucursalsRepository==null){SucursalsRepository = new SucursalsRepository();}return SucursalsRepository;
   }
   public SubramossRepository getSubramossRepository() {
       if(SubramossRepository==null){SubramossRepository = new SubramossRepository();}return SubramossRepository;
   }
   public ServerSessionsRepository getServerSessionsRepository() {
       if(ServerSessionsRepository==null){ServerSessionsRepository = new ServerSessionsRepository();}return ServerSessionsRepository;
   }
   public SerieprodsRepository getSerieprodsRepository() {
       if(SerieprodsRepository==null){SerieprodsRepository = new SerieprodsRepository();}return SerieprodsRepository;
   }
   public SeriesRepository getSeriesRepository() {
       if(SeriesRepository==null){SeriesRepository = new SeriesRepository();}return SeriesRepository;
   }
   public SectoressRepository getSectoressRepository() {
       if(SectoressRepository==null){SectoressRepository = new SectoressRepository();}return SectoressRepository;
   }
   public SalessRepository getSalessRepository() {
       if(SalessRepository==null){SalessRepository = new SalessRepository();}return SalessRepository;
   }
   public RutssRepository getRutssRepository() {
       if(RutssRepository==null){RutssRepository = new RutssRepository();}return RutssRepository;
   }
   public RubrsRepository getRubrsRepository() {
       if(RubrsRepository==null){RubrsRepository = new RubrsRepository();}return RubrsRepository;
   }
   public ResponsablesRepository getResponsablesRepository() {
       if(ResponsablesRepository==null){ResponsablesRepository = new ResponsablesRepository();}return ResponsablesRepository;
   }
   public ResplogsRepository getResplogsRepository() {
       if(ResplogsRepository==null){ResplogsRepository = new ResplogsRepository();}return ResplogsRepository;
   }
   public RespsRepository getRespsRepository() {
       if(RespsRepository==null){RespsRepository = new RespsRepository();}return RespsRepository;
   }
   public RegistrossRepository getRegistrossRepository() {
       if(RegistrossRepository==null){RegistrossRepository = new RegistrossRepository();}return RegistrossRepository;
   }
   public RegistroemailsRepository getRegistroemailsRepository() {
       if(RegistroemailsRepository==null){RegistroemailsRepository = new RegistroemailsRepository();}return RegistroemailsRepository;
   }
   public PushNotificationsRepository getPushNotificationsRepository() {
       if(PushNotificationsRepository==null){PushNotificationsRepository = new PushNotificationsRepository();}return PushNotificationsRepository;
   }
   public ProductsRepository getProductsRepository() {
       if(ProductsRepository==null){ProductsRepository = new ProductsRepository();}return ProductsRepository;
   }
   public ProdpartsRepository getProdpartsRepository() {
       if(ProdpartsRepository==null){ProdpartsRepository = new ProdpartsRepository();}return ProdpartsRepository;
   }
   public PrevcomprssRepository getPrevcomprssRepository() {
       if(PrevcomprssRepository==null){PrevcomprssRepository = new PrevcomprssRepository();}return PrevcomprssRepository;
   }
   public PetissRepository getPetissRepository() {
       if(PetissRepository==null){PetissRepository = new PetissRepository();}return PetissRepository;
   }
   public PessRepository getPessRepository() {
       if(PessRepository==null){PessRepository = new PessRepository();}return PessRepository;
   }
   public PerssRepository getPerssRepository() {
       if(PerssRepository==null){PerssRepository = new PerssRepository();}return PerssRepository;
   }
   public PedidosPartssRepository getPedidosPartssRepository() {
       if(PedidosPartssRepository==null){PedidosPartssRepository = new PedidosPartssRepository();}return PedidosPartssRepository;
   }
   public PedidossRepository getPedidossRepository() {
       if(PedidossRepository==null){PedidossRepository = new PedidossRepository();}return PedidossRepository;
   }
   public PaymentFormsRepository getPaymentFormsRepository() {
       if(PaymentFormsRepository==null){PaymentFormsRepository = new PaymentFormsRepository();}return PaymentFormsRepository;
   }
   public PaymentsRepository getPaymentsRepository() {
       if(PaymentsRepository==null){PaymentsRepository = new PaymentsRepository();}return PaymentsRepository;
   }
   public PartvtasRepository getPartvtasRepository() {
       if(PartvtasRepository==null){PartvtasRepository = new PartvtasRepository();}return PartvtasRepository;
   }
   public PartprevcomprsTmpsRepository getPartprevcomprsTmpsRepository() {
       if(PartprevcomprsTmpsRepository==null){PartprevcomprsTmpsRepository = new PartprevcomprsTmpsRepository();}return PartprevcomprsTmpsRepository;
   }
   public PartprevcomprssRepository getPartprevcomprssRepository() {
       if(PartprevcomprssRepository==null){PartprevcomprssRepository = new PartprevcomprssRepository();}return PartprevcomprssRepository;
   }
   public PartordssRepository getPartordssRepository() {
       if(PartordssRepository==null){PartordssRepository = new PartordssRepository();}return PartordssRepository;
   }
   public PartflujactsRepository getPartflujactsRepository() {
       if(PartflujactsRepository==null){PartflujactsRepository = new PartflujactsRepository();}return PartflujactsRepository;
   }
   public PartcotsRepository getPartcotsRepository() {
       if(PartcotsRepository==null){PartcotsRepository = new PartcotsRepository();}return PartcotsRepository;
   }
}