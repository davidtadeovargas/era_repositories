/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.logger.LoggerUtility;

/**
 *
 * @author PC
 */
public class RepositoryFactory {
    
    //Singleton
    private static RepositoryFactory RepositoryManager;
    
    //Repositories
    private CompanyRepository CompanyRepository;
    private LicenseRepository LicenseRepository;
    private PushNotificationsRepository PushNotificationsRepository;
    private BasDatsRepository BasDatsRepository;
    private ProductRepository ProductRepository;
    private SerieRepository SerieRepository;
    private DocumentOriginRepository DocumentOriginRepository;    
    private ServerSessionRepository ServerSessionRepository;
    private SuppliersRepository SuppliersRepository;
    private UsersRepository UsersRepository;
    private MetodosPagoRepository MetodosPagoRepository;
    private DeliverAddressCustomerRepository DeliverAddressCustomerRepository;
    private LogRepository LogRepository;
    private ConsecsRepository ConsecsRepository;    
    private UsoCfdiRepository UsoCfdiRepository;
    private GeneralConfigsRepository GeneralConfigsRepository;
    private PaymentFormsRepository PaymentFormsRepository;
    private SalesRepository SalesRepository;
    private WarehousesRepository WarehousesRepository;
    private UserPermissionRepository UserPermissionRepository;
    private ConcepsRepository ConcepsRepository;
    private CoinsRepository CoinsRepository;
    private MeasureRepository MeasureRepository;
    private TaxesRepository TaxesRepository;
    private PaymentRepository PaymentRepository;
    private UnidsRepository UnidsRepository;
    private LinesRepository LinesRepository;
    private CAduanaRepository CAduanaRepository;
    private CClaveunidadRepository CClaveunidadRepository;
    private CCodigoPostalRepository CCodigoPostalRepository;
    private CPaymentRepository CPaymentRepository;
    private CPaymentMethodRepository CPaymentMethodRepository;
    private CCoinRepository CCoinRepository;
    private CCountriesRepository CCountriesRepository;
    private CRegimenFiscalRepository CRegimenFiscalRepository;
    private CTipoComprobanteRepository CTipoComprobanteRepository;
    private CTipoRelacionRepository CTipoRelacionRepository;
    private CUsoCFDIRepository CUsoCFDIRepository;
    private CClaveProdServRepository CClaveProdServRepository;    
    private CPaymentFormRepository CPaymentFormRepository;
    private CFDIRelacionadosPagoRepository CFDIRelacionadosPagoRepository;
    private BancoRepository BancoRepository;
    private AuxiliarRepository AuxiliarRepository;
    private AsocdescRepository AsocdescRepository;
    private AsientosContablesRepository AsientosContablesRepository;
    private AnaqsRepository AnaqsRepository;
    private AlmasRepository AlmasRepository;
    private AduanaRepository AduanaRepository;
    private ActivosRepository ActivosRepository;
    private ActfijcatRepository ActfijcatRepository;
    private ActfijRepository ActfijRepository;
    private CortszxRepository CortszxRepository;
    private CortesRepository CortesRepository;
    private CorrselecRepository CorrselecRepository;
    private CorreoTerminalRepository CorreoTerminalRepository;
    private ControlexportarRepository ControlexportarRepository;
    private ContrasRepository ContrasRepository;
    private ConfgralRepository ConfgralRepository;
    private ConceppagRepository ConceppagRepository;
    private ConcepnotRepository ConcepnotRepository;
    private ComprsTmpRepository ComprsTmpRepository;
    private ComprsRepository ComprsRepository;
    private ColosRepository ColosRepository;
    private ClasprovRepository ClasprovRepository;
    private ClasprodRepository ClasprodRepository;
    private ClasjeraprovRepository ClasjeraprovRepository;
    private ClasjeraprodRepository ClasjeraprodRepository;
    private ClasjeracliRepository ClasjeracliRepository;
    private ClasificacionRepository ClasificacionRepository;
    private ClasempRepository ClasempRepository;
    private ChatRepository ChatRepository;
    private GeneralConfigRepository GeneralConfigRepository;
    private GaranRepository GaranRepository;
    private FlujactRepository FlujactRepository;
    private FlujRepository FlujRepository;
    private FacturasRepository FacturasRepository;
    private FabsRepository FabsRepository;
    private ExistalmaRepository ExistalmaRepository;
    private EstadiscorRepository EstadiscorRepository;
    private ERPermisosRepository ERPermisosRepository;
    private ERMmovimientosInventRepositoryario ERMmovimientosInventRepositoryario;
    private EREjerciciosRepository EREjerciciosRepository;
    private DomentcliRepository DomentcliRepository;
    private DocumentosPagoRepository DocumentosPagoRepository;
    private DocumentosOrigenRepository DocumentosOrigenRepository;
    private DocumentosContabilizadosRepository DocumentosContabilizadosRepository;
    private DatoscpRepository DatoscpRepository;
    private CxpRepository CxpRepository;
    private CxcRepository CxcRepository;
    private CumpleRepository CumpleRepository;
    private CuentasContablesRepository CuentasContablesRepository;
    private CotsRepository CotsRepository;
    private CostsRepository CostsRepository;
    private PartcomprsTmpRepository PartcomprsTmpRepository;
    private PartcomprsRepository PartcomprsRepository;
    private OrdsRepository OrdsRepository;
    private MsjsRepository MsjsRepository;
    private MovimientosPagosRepository MovimientosPagosRepository;
    private MovimientosAsientosRepository MovimientosAsientosRepository;
    private MoninvenRepository MoninvenRepository;
    private ModificaImpuestosRepository ModificaImpuestosRepository;
    private ModelprodRepository ModelprodRepository;
    private ModelRepository ModelRepository;
    private MetogoPagoRepository MetogoPagoRepository;
    private MedsRepository MedsRepository;
    private MaxminconfRepository MaxminconfRepository;
    private MarcsRepository MarcsRepository;
    private MarcprodRepository MarcprodRepository;
    private LugsRepository LugsRepository;    
    private KitsRepository KitsRepository;
    private IngresosEncabRepository IngresosEncabRepository;
    private IngresRepository IngresRepository;
    private ImpuesxpartidapedRepository ImpuesxpartidapedRepository;
    private ImpuesxpartidacotRepository ImpuesxpartidacotRepository;
    private ImpuestosXVentaRepository ImpuestosXVentaRepository;
    private ImpuestosXCompraRepository ImpuestosXCompraRepository;
    private ImpuestosVentaRepository ImpuestosVentaRepository;
    private ImpuesXProductRepository ImpuesXProductRepository;
    private HistAntiguedaddesaldoRepository HistAntiguedaddesaldoRepository;
    private GralsRepository GralsRepository;
    private GiroRepository GiroRepository;
    private resp355834Repository resp355834Repository;
    private ZonaRepository ZonaRepository;    
    private UsuarioserieRepository UsuarioserieRepository;    
    private UbiadRepository UbiadRepository;
    private TraspasRepository TraspasRepository;
    private TipscambRepository TipscambRepository;
    private TipsRepository TipsRepository;
    private TipactfijRepository TipactfijRepository;
    private TerprodcompaRepository TerprodcompaRepository;
    private TermarcamodeloRepository TermarcamodeloRepository;
    private TarsRepository TarsRepository;
    private TallcoloRepository TallcoloRepository;
    private TallRepository TallRepository;    
    private SucursalRepository SucursalRepository;
    private SubramosRepository SubramosRepository;
    private SerieprodRepository SerieprodRepository;
    private SectoresRepository SectoresRepository;
    private RutsRepository RutsRepository;
    private RubrRepository RubrRepository;
    private ResponsableRepository ResponsableRepository;
    private ResplogRepository ResplogRepository;
    private RespRepository RespRepository;
    private RegistrosRepository RegistrosRepository;
    private RegistroemailRepository RegistroemailRepository;
    private PushNotificationRepository PushNotificationRepository;
    private ProdpartRepository ProdpartRepository;
    private PrevcomprsRepository PrevcomprsRepository;
    private PetisRepository PetisRepository;
    private PesRepository PesRepository;
    private PersRepository PersRepository;
    private PedidosPartsRepository PedidosPartsRepository;
    private PedidosRepository PedidosRepository;
    private PartvtaRepository PartvtaRepository;
    private PartprevcomprsTmpRepository PartprevcomprsTmpRepository;
    private PartprevcomprsRepository PartprevcomprsRepository;
    private PartordsRepository PartordsRepository;
    private PartflujactRepository PartflujactRepository;
    private PartcotRepository PartcotRepository;
    private LotpedRepository LotpedRepository;
    
    //Singleton
    private RepositoryFactory(){
    }
    
    final public static RepositoryFactory getInstance(){
        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Getting instance repository manager");
        
        if(RepositoryManager==null){
            RepositoryManager = new RepositoryFactory();
        }
        return RepositoryManager;
    }
    
    public CompanyRepository getCompanyRepository() {
        if(CompanyRepository==null){CompanyRepository = new CompanyRepository();}return CompanyRepository;
    }

    public LicenseRepository getLicenseRepository() {
        if(LicenseRepository==null){LicenseRepository = new LicenseRepository();}return LicenseRepository;
    }

    public PushNotificationsRepository getPushNotificationsRepository() {
        if(PushNotificationsRepository==null){PushNotificationsRepository = new PushNotificationsRepository();}return PushNotificationsRepository;
    }

    public BasDatsRepository getBasDatsRepository() {
        if(BasDatsRepository==null){BasDatsRepository = new BasDatsRepository();}return BasDatsRepository;
    }

    public ProductRepository getProductRepository() {
        if(ProductRepository==null){ProductRepository = new ProductRepository();}return ProductRepository;
    }

    public SerieRepository getSerieRepository() {
        if(SerieRepository==null){SerieRepository = new SerieRepository();}return SerieRepository;
    }

    public DocumentOriginRepository getDocumentOriginRepository() {
        if(DocumentOriginRepository==null){DocumentOriginRepository = new DocumentOriginRepository();}return DocumentOriginRepository;
    }

    public ServerSessionRepository getServerSessionRepository() {
        if(ServerSessionRepository==null){ServerSessionRepository = new ServerSessionRepository();}return ServerSessionRepository;
    }

    public SuppliersRepository getSuppliersRepository() {
        if(SuppliersRepository==null){SuppliersRepository = new SuppliersRepository();}return SuppliersRepository;
    }

    public UsersRepository getUsersRepository() {
        if(UsersRepository==null){UsersRepository = new UsersRepository();}return UsersRepository;
    }

    public MetodosPagoRepository getMetodosPagoRepository() {
        if(MetodosPagoRepository==null){MetodosPagoRepository = new MetodosPagoRepository();}return MetodosPagoRepository;
    }

    public DeliverAddressCustomerRepository getDeliverAddressCustomerRepository() {
        if(DeliverAddressCustomerRepository==null){DeliverAddressCustomerRepository = new DeliverAddressCustomerRepository();}return DeliverAddressCustomerRepository;
    }

    public LogRepository getLogRepository() {
        if(LogRepository==null){LogRepository = new LogRepository();}return LogRepository;
    }

    public ConsecsRepository getConsecsRepository() {
        if(ConsecsRepository==null){ConsecsRepository = new ConsecsRepository();}return ConsecsRepository;
    }

    public UsoCfdiRepository getUsoCfdiRepository() {
        if(UsoCfdiRepository==null){UsoCfdiRepository = new UsoCfdiRepository();}return UsoCfdiRepository;
    }

    public GeneralConfigsRepository getGeneralConfigsRepository() {
        if(GeneralConfigsRepository==null){GeneralConfigsRepository = new GeneralConfigsRepository();}return GeneralConfigsRepository;
    }

    public PaymentFormsRepository getPaymentFormsRepository() {
        if(PaymentFormsRepository==null){PaymentFormsRepository = new PaymentFormsRepository();}return PaymentFormsRepository;
    }

    public SalesRepository getSalesRepository() {
        if(SalesRepository==null){SalesRepository = new SalesRepository();}return SalesRepository;
    }

    public WarehousesRepository getWarehousesRepository() {
        if(WarehousesRepository==null){WarehousesRepository = new WarehousesRepository();}return WarehousesRepository;
    }

    public UserPermissionRepository getUserPermissionRepository() {
        if(UserPermissionRepository==null){UserPermissionRepository = new UserPermissionRepository();}return UserPermissionRepository;
    }

    public ConcepsRepository getConcepsRepository() {
        if(ConcepsRepository==null){ConcepsRepository = new ConcepsRepository();}return ConcepsRepository;
    }

    public CoinsRepository getCoinsRepository() {
        if(CoinsRepository==null){CoinsRepository = new CoinsRepository();}return CoinsRepository;
    }

    public MeasureRepository getMeasureRepository() {
        if(MeasureRepository==null){MeasureRepository = new MeasureRepository();}return MeasureRepository;
    }

    public TaxesRepository getTaxesRepository() {
        if(TaxesRepository==null){TaxesRepository = new TaxesRepository();}return TaxesRepository;
    }

    public PaymentRepository getPaymentRepository() {
        if(PaymentRepository==null){PaymentRepository = new PaymentRepository();}return PaymentRepository;
    }

    public UnidsRepository getUnidsRepository() {
        if(UnidsRepository==null){UnidsRepository = new UnidsRepository();}return UnidsRepository;
    }

    public LinesRepository getLinesRepository() {
        if(LinesRepository==null){LinesRepository = new LinesRepository();}return LinesRepository;
    }

    public CAduanaRepository getCAduanaRepository() {
        if(CAduanaRepository==null){CAduanaRepository = new CAduanaRepository();}return CAduanaRepository;
    }

    public CClaveunidadRepository getCClaveunidadRepository() {
        if(CClaveunidadRepository==null){CClaveunidadRepository = new CClaveunidadRepository();}return CClaveunidadRepository;
    }

    public CCodigoPostalRepository getCCodigoPostalRepository() {
        if(CCodigoPostalRepository==null){CCodigoPostalRepository = new CCodigoPostalRepository();}return CCodigoPostalRepository;
    }

    public CPaymentRepository getCPaymentRepository() {
        if(CPaymentRepository==null){CPaymentRepository = new CPaymentRepository();}return CPaymentRepository;
    }

    public CPaymentMethodRepository getCPaymentMethodRepository() {
        if(CPaymentMethodRepository==null){CPaymentMethodRepository = new CPaymentMethodRepository();}return CPaymentMethodRepository;
    }

    public CCoinRepository getCCoinRepository() {
        if(CCoinRepository==null){CCoinRepository = new CCoinRepository();}return CCoinRepository;
    }

    public CCountriesRepository getCCountriesRepository() {
        if(CCountriesRepository==null){CCountriesRepository = new CCountriesRepository();}return CCountriesRepository;
    }

    public CRegimenFiscalRepository getCRegimenFiscalRepository() {
        if(CRegimenFiscalRepository==null){CRegimenFiscalRepository = new CRegimenFiscalRepository();}return CRegimenFiscalRepository;
    }

    public CTipoComprobanteRepository getCTipoComprobanteRepository() {
        if(CTipoComprobanteRepository==null){CTipoComprobanteRepository = new CTipoComprobanteRepository();}return CTipoComprobanteRepository;
    }

    public CTipoRelacionRepository getCTipoRelacionRepository() {
        if(CTipoRelacionRepository==null){CTipoRelacionRepository = new CTipoRelacionRepository();}return CTipoRelacionRepository;
    }

    public CUsoCFDIRepository getCUsoCFDIRepository() {
        if(CUsoCFDIRepository==null){CUsoCFDIRepository = new CUsoCFDIRepository();}return CUsoCFDIRepository;
    }

    public CClaveProdServRepository getCClaveProdServRepository() {
        if(CClaveProdServRepository==null){CClaveProdServRepository = new CClaveProdServRepository();}return CClaveProdServRepository;
    }

    public CPaymentFormRepository getCPaymentFormRepository() {
        if(CPaymentFormRepository==null){CPaymentFormRepository = new CPaymentFormRepository();}return CPaymentFormRepository;
    }

    public CFDIRelacionadosPagoRepository getCFDIRelacionadosPagoRepository() {
        if(CFDIRelacionadosPagoRepository==null){CFDIRelacionadosPagoRepository = new CFDIRelacionadosPagoRepository();}return CFDIRelacionadosPagoRepository;
    }

    public BancoRepository getBancoRepository() {
        if(BancoRepository==null){BancoRepository = new BancoRepository();}return BancoRepository;
    }

    public AuxiliarRepository getAuxiliarRepository() {
        if(AuxiliarRepository==null){AuxiliarRepository = new AuxiliarRepository();}return AuxiliarRepository;
    }

    public AsocdescRepository getAsocdescRepository() {
        if(AsocdescRepository==null){AsocdescRepository = new AsocdescRepository();}return AsocdescRepository;
    }

    public AsientosContablesRepository getAsientosContablesRepository() {
        if(AsientosContablesRepository==null){AsientosContablesRepository = new AsientosContablesRepository();}return AsientosContablesRepository;
    }

    public AnaqsRepository getAnaqsRepository() {
        if(AnaqsRepository==null){AnaqsRepository = new AnaqsRepository();}return AnaqsRepository;
    }

    public AlmasRepository getAlmasRepository() {
        if(AlmasRepository==null){AlmasRepository = new AlmasRepository();}return AlmasRepository;
    }

    public AduanaRepository getAduanaRepository() {
        if(AduanaRepository==null){AduanaRepository = new AduanaRepository();}return AduanaRepository;
    }

    public ActivosRepository getActivosRepository() {
        if(ActivosRepository==null){ActivosRepository = new ActivosRepository();}return ActivosRepository;
    }

    public ActfijcatRepository getActfijcatRepository() {
        if(ActfijcatRepository==null){ActfijcatRepository = new ActfijcatRepository();}return ActfijcatRepository;
    }

    public ActfijRepository getActfijRepository() {
        if(ActfijRepository==null){ActfijRepository = new ActfijRepository();}return ActfijRepository;
    }

    public CortszxRepository getCortszxRepository() {
        if(CortszxRepository==null){CortszxRepository = new CortszxRepository();}return CortszxRepository;
    }

    public CortesRepository getCortesRepository() {
        if(CortesRepository==null){CortesRepository = new CortesRepository();}return CortesRepository;
    }

    public CorrselecRepository getCorrselecRepository() {
        if(CorrselecRepository==null){CorrselecRepository = new CorrselecRepository();}return CorrselecRepository;
    }

    public CorreoTerminalRepository getCorreoTerminalRepository() {
        if(CorreoTerminalRepository==null){CorreoTerminalRepository = new CorreoTerminalRepository();}return CorreoTerminalRepository;
    }

    public ControlexportarRepository getControlexportarRepository() {
        if(ControlexportarRepository==null){ControlexportarRepository = new ControlexportarRepository();}return ControlexportarRepository;
    }

    public ContrasRepository getContrasRepository() {
        if(ContrasRepository==null){ContrasRepository = new ContrasRepository();}return ContrasRepository;
    }

    public ConfgralRepository getConfgralRepository() {
        if(ConfgralRepository==null){ConfgralRepository = new ConfgralRepository();}return ConfgralRepository;
    }

    public ConceppagRepository getConceppagRepository() {
        if(ConceppagRepository==null){ConceppagRepository = new ConceppagRepository();}return ConceppagRepository;
    }

    public ConcepnotRepository getConcepnotRepository() {
        if(ConcepnotRepository==null){ConcepnotRepository = new ConcepnotRepository();}return ConcepnotRepository;
    }

    public ComprsTmpRepository getComprsTmpRepository() {
        if(ComprsTmpRepository==null){ComprsTmpRepository = new ComprsTmpRepository();}return ComprsTmpRepository;
    }

    public ComprsRepository getComprsRepository() {
        if(ComprsRepository==null){ComprsRepository = new ComprsRepository();}return ComprsRepository;
    }

    public ColosRepository getColosRepository() {
        if(ColosRepository==null){ColosRepository = new ColosRepository();}return ColosRepository;
    }

    public ClasprovRepository getClasprovRepository() {
        if(ClasprovRepository==null){ClasprovRepository = new ClasprovRepository();}return ClasprovRepository;
    }

    public ClasprodRepository getClasprodRepository() {
        if(ClasprodRepository==null){ClasprodRepository = new ClasprodRepository();}return ClasprodRepository;
    }

    public ClasjeraprovRepository getClasjeraprovRepository() {
        if(ClasjeraprovRepository==null){ClasjeraprovRepository = new ClasjeraprovRepository();}return ClasjeraprovRepository;
    }

    public ClasjeraprodRepository getClasjeraprodRepository() {
        if(ClasjeraprodRepository==null){ClasjeraprodRepository = new ClasjeraprodRepository();}return ClasjeraprodRepository;
    }

    public ClasjeracliRepository getClasjeracliRepository() {
        if(ClasjeracliRepository==null){ClasjeracliRepository = new ClasjeracliRepository();}return ClasjeracliRepository;
    }

    public ClasificacionRepository getClasificacionRepository() {
        if(ClasificacionRepository==null){ClasificacionRepository = new ClasificacionRepository();}return ClasificacionRepository;
    }

    public ClasempRepository getClasempRepository() {
        if(ClasempRepository==null){ClasempRepository = new ClasempRepository();}return ClasempRepository;
    }

    public ChatRepository getChatRepository() {
        if(ChatRepository==null){ChatRepository = new ChatRepository();}return ChatRepository;
    }

    public GeneralConfigRepository getGeneralConfigRepository() {
        if(GeneralConfigRepository==null){GeneralConfigRepository = new GeneralConfigRepository();}return GeneralConfigRepository;
    }

    public GaranRepository getGaranRepository() {
        if(GaranRepository==null){GaranRepository = new GaranRepository();}return GaranRepository;
    }

    public FlujactRepository getFlujactRepository() {
        if(FlujactRepository==null){FlujactRepository = new FlujactRepository();}return FlujactRepository;
    }

    public FlujRepository getFlujRepository() {
        if(FlujRepository==null){FlujRepository = new FlujRepository();}return FlujRepository;
    }

    public FacturasRepository getFacturasRepository() {
        if(FacturasRepository==null){FacturasRepository = new FacturasRepository();}return FacturasRepository;
    }

    public FabsRepository getFabsRepository() {
        if(FabsRepository==null){FabsRepository = new FabsRepository();}return FabsRepository;
    }

    public ExistalmaRepository getExistalmaRepository() {
        if(ExistalmaRepository==null){ExistalmaRepository = new ExistalmaRepository();}return ExistalmaRepository;
    }

    public EstadiscorRepository getEstadiscorRepository() {
        if(EstadiscorRepository==null){EstadiscorRepository = new EstadiscorRepository();}return EstadiscorRepository;
    }

    public ERPermisosRepository getERPermisosRepository() {
        if(ERPermisosRepository==null){ERPermisosRepository = new ERPermisosRepository();}return ERPermisosRepository;
    }

    public ERMmovimientosInventRepositoryario getERMmovimientosInventRepositoryario() {
        if(ERMmovimientosInventRepositoryario==null){ERMmovimientosInventRepositoryario = new ERMmovimientosInventRepositoryario();}return ERMmovimientosInventRepositoryario;
    }

    public EREjerciciosRepository getEREjerciciosRepository() {
        if(EREjerciciosRepository==null){EREjerciciosRepository = new EREjerciciosRepository();}return EREjerciciosRepository;
    }

    public DomentcliRepository getDomentcliRepository() {
        if(DomentcliRepository==null){DomentcliRepository = new DomentcliRepository();}return DomentcliRepository;
    }

    public DocumentosPagoRepository getDocumentosPagoRepository() {
        if(DocumentosPagoRepository==null){DocumentosPagoRepository = new DocumentosPagoRepository();}return DocumentosPagoRepository;
    }

    public DocumentosOrigenRepository getDocumentosOrigenRepository() {
        if(DocumentosOrigenRepository==null){DocumentosOrigenRepository = new DocumentosOrigenRepository();}return DocumentosOrigenRepository;
    }

    public DocumentosContabilizadosRepository getDocumentosContabilizadosRepository() {
        if(DocumentosContabilizadosRepository==null){DocumentosContabilizadosRepository = new DocumentosContabilizadosRepository();}return DocumentosContabilizadosRepository;
    }

    public DatoscpRepository getDatoscpRepository() {
        if(DatoscpRepository==null){DatoscpRepository = new DatoscpRepository();}return DatoscpRepository;
    }

    public CxpRepository getCxpRepository() {
        if(CxpRepository==null){CxpRepository = new CxpRepository();}return CxpRepository;
    }

    public CxcRepository getCxcRepository() {
        if(CxcRepository==null){CxcRepository = new CxcRepository();}return CxcRepository;
    }

    public CumpleRepository getCumpleRepository() {
        if(CumpleRepository==null){CumpleRepository = new CumpleRepository();}return CumpleRepository;
    }

    public CuentasContablesRepository getCuentasContablesRepository() {
        if(CuentasContablesRepository==null){CuentasContablesRepository = new CuentasContablesRepository();}return CuentasContablesRepository;
    }

    public CotsRepository getCotsRepository() {
        if(CotsRepository==null){CotsRepository = new CotsRepository();}return CotsRepository;
    }

    public CostsRepository getCostsRepository() {
        if(CostsRepository==null){CostsRepository = new CostsRepository();}return CostsRepository;
    }

    public PartcomprsTmpRepository getPartcomprsTmpRepository() {
        if(PartcomprsTmpRepository==null){PartcomprsTmpRepository = new PartcomprsTmpRepository();}return PartcomprsTmpRepository;
    }

    public PartcomprsRepository getPartcomprsRepository() {
        if(PartcomprsRepository==null){PartcomprsRepository = new PartcomprsRepository();}return PartcomprsRepository;
    }

    public OrdsRepository getOrdsRepository() {
        if(OrdsRepository==null){OrdsRepository = new OrdsRepository();}return OrdsRepository;
    }

    public MsjsRepository getMsjsRepository() {
        if(MsjsRepository==null){MsjsRepository = new MsjsRepository();}return MsjsRepository;
    }

    public MovimientosPagosRepository getMovimientosPagosRepository() {
        if(MovimientosPagosRepository==null){MovimientosPagosRepository = new MovimientosPagosRepository();}return MovimientosPagosRepository;
    }

    public MovimientosAsientosRepository getMovimientosAsientosRepository() {
        if(MovimientosAsientosRepository==null){MovimientosAsientosRepository = new MovimientosAsientosRepository();}return MovimientosAsientosRepository;
    }

    public MoninvenRepository getMoninvenRepository() {
        if(MoninvenRepository==null){MoninvenRepository = new MoninvenRepository();}return MoninvenRepository;
    }

    public ModificaImpuestosRepository getModificaImpuestosRepository() {
        if(ModificaImpuestosRepository==null){ModificaImpuestosRepository = new ModificaImpuestosRepository();}return ModificaImpuestosRepository;
    }

    public ModelprodRepository getModelprodRepository() {
        if(ModelprodRepository==null){ModelprodRepository = new ModelprodRepository();}return ModelprodRepository;
    }

    public ModelRepository getModelRepository() {
        if(ModelRepository==null){ModelRepository = new ModelRepository();}return ModelRepository;
    }

    public MetogoPagoRepository getMetogoPagoRepository() {
        if(MetogoPagoRepository==null){MetogoPagoRepository = new MetogoPagoRepository();}return MetogoPagoRepository;
    }

    public MedsRepository getMedsRepository() {
        if(MedsRepository==null){MedsRepository = new MedsRepository();}return MedsRepository;
    }

    public MaxminconfRepository getMaxminconfRepository() {
        if(MaxminconfRepository==null){MaxminconfRepository = new MaxminconfRepository();}return MaxminconfRepository;
    }

    public MarcsRepository getMarcsRepository() {
        if(MarcsRepository==null){MarcsRepository = new MarcsRepository();}return MarcsRepository;
    }

    public MarcprodRepository getMarcprodRepository() {
        if(MarcprodRepository==null){MarcprodRepository = new MarcprodRepository();}return MarcprodRepository;
    }

    public LugsRepository getLugsRepository() {
        if(LugsRepository==null){LugsRepository = new LugsRepository();}return LugsRepository;
    }

    public KitsRepository getKitsRepository() {
        if(KitsRepository==null){KitsRepository = new KitsRepository();}return KitsRepository;
    }

    public IngresosEncabRepository getIngresosEncabRepository() {
        if(IngresosEncabRepository==null){IngresosEncabRepository = new IngresosEncabRepository();}return IngresosEncabRepository;
    }

    public IngresRepository getIngresRepository() {
        if(IngresRepository==null){IngresRepository = new IngresRepository();}return IngresRepository;
    }

    public ImpuesxpartidapedRepository getImpuesxpartidapedRepository() {
        if(ImpuesxpartidapedRepository==null){ImpuesxpartidapedRepository = new ImpuesxpartidapedRepository();}return ImpuesxpartidapedRepository;
    }

    public ImpuesxpartidacotRepository getImpuesxpartidacotRepository() {
        if(ImpuesxpartidacotRepository==null){ImpuesxpartidacotRepository = new ImpuesxpartidacotRepository();}return ImpuesxpartidacotRepository;
    }

    public ImpuestosXVentaRepository getImpuestosXVentaRepository() {
        if(ImpuestosXVentaRepository==null){ImpuestosXVentaRepository = new ImpuestosXVentaRepository();}return ImpuestosXVentaRepository;
    }

    public ImpuestosXCompraRepository getImpuestosXCompraRepository() {
        if(ImpuestosXCompraRepository==null){ImpuestosXCompraRepository = new ImpuestosXCompraRepository();}return ImpuestosXCompraRepository;
    }

    public ImpuestosVentaRepository getImpuestosVentaRepository() {
        if(ImpuestosVentaRepository==null){ImpuestosVentaRepository = new ImpuestosVentaRepository();}return ImpuestosVentaRepository;
    }

    public ImpuesXProductRepository getImpuesXProductRepository() {
        if(ImpuesXProductRepository==null){ImpuesXProductRepository = new ImpuesXProductRepository();}return ImpuesXProductRepository;
    }

    public HistAntiguedaddesaldoRepository getHistAntiguedaddesaldoRepository() {
        if(HistAntiguedaddesaldoRepository==null){HistAntiguedaddesaldoRepository = new HistAntiguedaddesaldoRepository();}return HistAntiguedaddesaldoRepository;
    }

    public GralsRepository getGralsRepository() {
        if(GralsRepository==null){GralsRepository = new GralsRepository();}return GralsRepository;
    }

    public GiroRepository getGiroRepository() {
        if(GiroRepository==null){GiroRepository = new GiroRepository();}return GiroRepository;
    }

    public resp355834Repository getresp355834Repository() {
        if(resp355834Repository==null){resp355834Repository = new resp355834Repository();}return resp355834Repository;
    }

    public ZonaRepository getZonaRepository() {
        if(ZonaRepository==null){ZonaRepository = new ZonaRepository();}return ZonaRepository;
    }

    public UsuarioserieRepository getUsuarioserieRepository() {
        if(UsuarioserieRepository==null){UsuarioserieRepository = new UsuarioserieRepository();}return UsuarioserieRepository;
    }

    public UbiadRepository getUbiadRepository() {
        if(UbiadRepository==null){UbiadRepository = new UbiadRepository();}return UbiadRepository;
    }

    public TraspasRepository getTraspasRepository() {
        if(TraspasRepository==null){TraspasRepository = new TraspasRepository();}return TraspasRepository;
    }

    public TipscambRepository getTipscambRepository() {
        if(TipscambRepository==null){TipscambRepository = new TipscambRepository();}return TipscambRepository;
    }

    public TipsRepository getTipsRepository() {
        if(TipsRepository==null){TipsRepository = new TipsRepository();}return TipsRepository;
    }

    public TipactfijRepository getTipactfijRepository() {
        if(TipactfijRepository==null){TipactfijRepository = new TipactfijRepository();}return TipactfijRepository;
    }

    public TerprodcompaRepository getTerprodcompaRepository() {
        if(TerprodcompaRepository==null){TerprodcompaRepository = new TerprodcompaRepository();}return TerprodcompaRepository;
    }

    public TermarcamodeloRepository getTermarcamodeloRepository() {
        if(TermarcamodeloRepository==null){TermarcamodeloRepository = new TermarcamodeloRepository();}return TermarcamodeloRepository;
    }

    public TarsRepository getTarsRepository() {
        if(TarsRepository==null){TarsRepository = new TarsRepository();}return TarsRepository;
    }

    public TallcoloRepository getTallcoloRepository() {
        if(TallcoloRepository==null){TallcoloRepository = new TallcoloRepository();}return TallcoloRepository;
    }

    public TallRepository getTallRepository() {
        if(TallRepository==null){TallRepository = new TallRepository();}return TallRepository;
    }

    public SucursalRepository getSucursalRepository() {
        if(SucursalRepository==null){SucursalRepository = new SucursalRepository();}return SucursalRepository;
    }

    public SubramosRepository getSubramosRepository() {
        if(SubramosRepository==null){SubramosRepository = new SubramosRepository();}return SubramosRepository;
    }

    public SerieprodRepository getSerieprodRepository() {
        if(SerieprodRepository==null){SerieprodRepository = new SerieprodRepository();}return SerieprodRepository;
    }

    public SectoresRepository getSectoresRepository() {
        if(SectoresRepository==null){SectoresRepository = new SectoresRepository();}return SectoresRepository;
    }

    public RutsRepository getRutsRepository() {
        if(RutsRepository==null){RutsRepository = new RutsRepository();}return RutsRepository;
    }

    public RubrRepository getRubrRepository() {
        if(RubrRepository==null){RubrRepository = new RubrRepository();}return RubrRepository;
    }

    public ResponsableRepository getResponsableRepository() {
        if(ResponsableRepository==null){ResponsableRepository = new ResponsableRepository();}return ResponsableRepository;
    }

    public ResplogRepository getResplogRepository() {
        if(ResplogRepository==null){ResplogRepository = new ResplogRepository();}return ResplogRepository;
    }

    public RespRepository getRespRepository() {
        if(RespRepository==null){RespRepository = new RespRepository();}return RespRepository;
    }

    public RegistrosRepository getRegistrosRepository() {
        if(RegistrosRepository==null){RegistrosRepository = new RegistrosRepository();}return RegistrosRepository;
    }

    public RegistroemailRepository getRegistroemailRepository() {
        if(RegistroemailRepository==null){RegistroemailRepository = new RegistroemailRepository();}return RegistroemailRepository;
    }

    public PushNotificationRepository getPushNotificationRepository() {
        if(PushNotificationRepository==null){PushNotificationRepository = new PushNotificationRepository();}return PushNotificationRepository;
    }

    public ProdpartRepository getProdpartRepository() {
        if(ProdpartRepository==null){ProdpartRepository = new ProdpartRepository();}return ProdpartRepository;
    }

    public PrevcomprsRepository getPrevcomprsRepository() {
        if(PrevcomprsRepository==null){PrevcomprsRepository = new PrevcomprsRepository();}return PrevcomprsRepository;
    }

    public PetisRepository getPetisRepository() {
        if(PetisRepository==null){PetisRepository = new PetisRepository();}return PetisRepository;
    }

    public PesRepository getPesRepository() {
        if(PesRepository==null){PesRepository = new PesRepository();}return PesRepository;
    }

    public PersRepository getPersRepository() {
        if(PersRepository==null){PersRepository = new PersRepository();}return PersRepository;
    }

    public PedidosPartsRepository getPedidosPartsRepository() {
        if(PedidosPartsRepository==null){PedidosPartsRepository = new PedidosPartsRepository();}return PedidosPartsRepository;
    }

    public PedidosRepository getPedidosRepository() {
        if(PedidosRepository==null){PedidosRepository = new PedidosRepository();}return PedidosRepository;
    }

    public PartvtaRepository getPartvtaRepository() {
        if(PartvtaRepository==null){PartvtaRepository = new PartvtaRepository();}return PartvtaRepository;
    }

    public PartprevcomprsTmpRepository getPartprevcomprsTmpRepository() {
        if(PartprevcomprsTmpRepository==null){PartprevcomprsTmpRepository = new PartprevcomprsTmpRepository();}return PartprevcomprsTmpRepository;
    }

    public PartprevcomprsRepository getPartprevcomprsRepository() {
        if(PartprevcomprsRepository==null){PartprevcomprsRepository = new PartprevcomprsRepository();}return PartprevcomprsRepository;
    }

    public PartordsRepository getPartordsRepository() {
        if(PartordsRepository==null){PartordsRepository = new PartordsRepository();}return PartordsRepository;
    }

    public PartflujactRepository getPartflujactRepository() {
        if(PartflujactRepository==null){PartflujactRepository = new PartflujactRepository();}return PartflujactRepository;
    }

    public PartcotRepository getPartcotRepository() {
        if(PartcotRepository==null){PartcotRepository = new PartcotRepository();}return PartcotRepository;
    }
    
    public LotpedRepository getLotpedRepository(){
        if(LotpedRepository==null){
            LotpedRepository = new LotpedRepository();
        }
        return LotpedRepository;
    }
}