package xin.tianchuang.modules.api.handler.tyc;

import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open440PatentsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;

import xin.tianchuang.modules.spider.entity.EntPatentsInfoEntity;
import xin.tianchuang.modules.spider.service.EntPatentsInfoService;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class PatentsHandler implements QueryHandler<List<Open440PatentsDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(PatentsHandler.class);

	// 占时不加批量增加
	@Autowired
	private EntPatentsInfoService entPatentsInfoService;

	@Override
	public BaseRespnseDTO<List<Open440PatentsDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/patents?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":\"1809\",\"items\":[{\"mainCatNum\":\"G06F13/42(2006.01)I\",\"createTime\":\"1515603891000\",\"pubnumber\":\"CN104731748B\",\"searchType\":\"402\",\"appnumber\":\"CN201510146480.7\",\"id\":\"43970665\",\"_type\":\"62\",\"title\":\"多路音频数据采集方法和装置\",\"patentName\":\"多路音频数据采集方法和装置\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2015.03.31\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2018.01.09\",\"applicationPublishNum\":\"CN104731748B\",\"agency\":\"北京清亦华知识产权代理事务所(普通合伙) 11201\",\"uni\":\"62044a3274aa644f4ed9eedc6d17386c\",\"inventor\":\"马东鹏;赵杰;王志谦;张家军\",\"agent\":\"宋合成\",\"applicationPublishTime\":\"2018.01.09\",\"patentNum\":\"CN201510146480.7\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/SQ/20180109/201510146480.7/201510146480.gif\",\"allCatNum\":\"G06F13/42(2006.01)I\",\"abstracts\":\"本发明提出一种多路音频数据采集方法和装置，该多路音频数据采集方法包括设置音频数据分路，以及设置数据采集控制器；在所述音频数据分路以及所述数据采集控制器设置完成后，再设置系统时钟的处理电路，所述处理电路输出的时钟信号输入到所述音频数据分路；采用设置完成的系统时钟的处理电路，音频数据分路以及数据采集控制器，进行多路音频数据采集。该方法能够实现多路音频数据的同步采集。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"c91ba6bba16940f695cb129d7d422928\",\"eventTime\":\"1515427200000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G06F17/30(2006.01)I\",\"createTime\":\"1515603955000\",\"pubnumber\":\"CN104123314B\",\"searchType\":\"402\",\"appnumber\":\"CN201310156441.6\",\"id\":\"43970254\",\"_type\":\"62\",\"title\":\"标注避让方法和装置\",\"patentName\":\"标注避让方法和装置\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2013.04.28\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2018.01.09\",\"applicationPublishNum\":\"CN104123314B\",\"agency\":\"北京清亦华知识产权代理事务所(普通合伙) 11201\",\"uni\":\"717ac260e5819e22486136f26f409e7b\",\"inventor\":\"刘阳;游东\",\"agent\":\"宋合成\",\"applicationPublishTime\":\"2018.01.09\",\"patentNum\":\"CN201310156441.6\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/SQ/20180109/201310156441.6/201310156441.gif\",\"allCatNum\":\"G06F17/30(2006.01)I\",\"abstracts\":\"本发明提出一种标注避让方法和装置，其中所述方法包括：获得多个矢量数据，并根据多个矢量数据的权重值对多个矢量数据进行排序；对排序之后得到的多个矢量数据按照顺序分别进行标注，其中，标注每个矢量数据时对排在其之前的矢量数据进行避让；以及对标注之后的多个矢量数据进行渲染。根据本发明实施例的方法，按照矢量数据的权重值对矢量数据进行按序标注，并在标注每个矢量数据时对排在其之前的矢量数据进行避让，保证了权重值高的矢量数据被优先标注，并且避免了标注之间的冲突和覆盖，方便用户识别和查看，提升了用户体验。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"22442cbe03f6443a9b670aa1daa2233e\",\"eventTime\":\"1515427200000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"H04L12/24(2006.01)I\",\"createTime\":\"1515603564000\",\"pubnumber\":\"CN104079438B\",\"searchType\":\"402\",\"appnumber\":\"CN201410345379.X\",\"id\":\"43845436\",\"_type\":\"62\",\"title\":\"DNS域名管理系统和方法\",\"patentName\":\"DNS域名管理系统和方法\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2014.07.18\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2018.01.09\",\"applicationPublishNum\":\"CN104079438B\",\"agency\":\"北京清亦华知识产权代理事务所(普通合伙) 11201\",\"uni\":\"41bd775a00c2e781f0de735aa62eccc7\",\"inventor\":\"任海科;余亮;关鹏;李明华;朱永忠\",\"agent\":\"宋合成\",\"applicationPublishTime\":\"2018.01.09\",\"patentNum\":\"CN201410345379.X\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/SQ/20180109/201410345379.X/201410345379.gif\",\"allCatNum\":\"H04L12/24(2006.01)I;H04L29/12(2006.01)I\",\"abstracts\":\"本发明公开了一种DNS域名管理系统和方法，其中该系统包括任务执行器、DNS主服务器集群和DNS从服务器集群，其中，任务执行器用于接收域名操作任务，并根据域名操作任务向DNS主服务器集群中的每个DNS主服务器发送域名操作任务请求；DNS主服务器集群用于根据域名操作任务请求对域名记录进行更新，并根据域名的更新部分生成域名记录更新指令，并将域名记录更新指令发送至DNS从服务器集群中的每个DNS从服务器；DNS从服务器集群用于根据域名记录更新指令进行更新，并提供DNS域名解析服务。本发明实施例的系统在保证域名操作过程高效执行的同时，增强了域名管理和解析的安全性和可靠性，提高了主/从服务器的同步效率。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"1da24900349042baaad1f0050081e9a9\",\"eventTime\":\"1515427200000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G06F17/30(2006.01)I\",\"createTime\":\"1515603618000\",\"pubnumber\":\"CN103914548B\",\"searchType\":\"402\",\"appnumber\":\"CN201410144036.7\",\"id\":\"43984038\",\"_type\":\"62\",\"title\":\"信息搜索方法和装置\",\"patentName\":\"信息搜索方法和装置\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2014.04.10\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2018.01.09\",\"applicationPublishNum\":\"CN103914548B\",\"agency\":\"北京清亦华知识产权代理事务所(普通合伙) 11201\",\"uni\":\"371dc15db1136bff975e0df24bfc546a\",\"inventor\":\"李婷婷;万伟;赵世奇\",\"agent\":\"宋合成\",\"applicationPublishTime\":\"2018.01.09\",\"patentNum\":\"CN201410144036.7\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/SQ/20180109/201410144036.7/201410144036.gif\",\"allCatNum\":\"G06F17/30(2006.01)I\",\"abstracts\":\"本发明提出一种信息搜索方法和装置。其中，方法包括：接收用户输入的查询信息，根据查询信息获得意图澄清引导语句；接收用户根据意图澄清引导语句输入的更新后的查询信息，根据更新后的查询信息获得搜索结果；以及向客户端返回搜索结果，以用于向用户展示。本发明实施例的信息搜索方法，通过接收用户输入的查询信息，根据查询信息获得意图澄清引导语句，并引导用户根据意图澄清引导语句更新查询信息，再根据更新后的查询信息获得搜索结果，引导和帮助用户对自己的搜索意图进行了澄清，提高了搜索引擎识别用户搜索意图的准确性，满足了用户的需求，从而提升了用户体验。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"84ad726adaa346489ecb66f82a3249ad\",\"eventTime\":\"1515427200000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G01M17/007(2006.01)I\",\"createTime\":\"1515601405000\",\"pubnumber\":\"CN107543725A\",\"searchType\":\"402\",\"appnumber\":\"CN201610603327.7\",\"id\":\"43885662\",\"_type\":\"62\",\"title\":\"一种无人车操控测试方法及装置\",\"patentName\":\"一种无人车操控测试方法及装置\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2016.07.27\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2018.01.05\",\"applicationPublishNum\":\"CN107543725A\",\"agency\":\"北京品源专利代理有限公司 11332\",\"uni\":\"ef8fbce64d6a4a01c15f7554fa301c3e\",\"inventor\":\"翟宏\",\"agent\":\"孟金喆;胡彬\",\"applicationPublishTime\":\"2018.01.05\",\"patentNum\":\"CN201610603327.7\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/FM/20180105/201610603327.7/201610603327.gif\",\"allCatNum\":\"G01M17/007(2006.01)I\",\"abstracts\":\"本发明公开了一种无人车操控测试方法及装置，无人车操控测试方法包括：将预设图片集中的预设图片输入无人车的车载大脑；获取所述车载大脑根据所述预设图片生成的操作指令；根据所述操作指令与所述预设图片对应的预设操作指令的匹配结果，输出操作指令测试结果。实现对无人车的操控进行模拟测试，验证无人车操控的可靠性，容易实现，成本较低。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"8759d2f68a8b44b793ba02458177c421\",\"eventTime\":\"1515081600000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G01M17/007(2006.01)I\",\"createTime\":\"1515603324000\",\"pubnumber\":\"CN107543726A\",\"searchType\":\"402\",\"appnumber\":\"CN201610609135.7\",\"id\":\"43910447\",\"_type\":\"62\",\"title\":\"一种无人车驾驶控制系统操控精度的测试方法及装置\",\"patentName\":\"一种无人车驾驶控制系统操控精度的测试方法及装置\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2016.07.28\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2018.01.05\",\"applicationPublishNum\":\"CN107543726A\",\"agency\":\"北京品源专利代理有限公司 11332\",\"uni\":\"7314eb371cd079d84867c957176ad65d\",\"inventor\":\"武毅\",\"agent\":\"孟金喆;高磊\",\"applicationPublishTime\":\"2018.01.05\",\"patentNum\":\"CN201610609135.7\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/FM/20180105/201610609135.7/201610609135.gif\",\"allCatNum\":\"G01M17/007(2006.01)I\",\"abstracts\":\"本发明公开了一种无人车驾驶控制系统操控精度的测试方法及装置。该方法包括：基于所获取的行驶数据信息，确定无人车中驾驶控制系统操控所述无人车时的操控轨迹长度；基于设定的操控精度测试标准，确定所述驾驶控制系统操控所述无人车时的标准操控距离；比较所述操控轨迹长度与所述标准操控距离，以确定所述驾驶操控系统操控精度的测试结果。利用该测试方法，能够通过设定的操控精度测试标准实现对无人车中驾驶控制系统操控精度的测试，由此确保无人车的驾驶控制系统能够在实际行驶过程中精确操控无人车，进而保证无人车驾驶时车辆自身的运行安全、交通运输环境的安全以及乘客的生命安全。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"31083ca68ff7496ba79fe0d8861825dc\",\"eventTime\":\"1515081600000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G06F17/30(2006.01)I\",\"createTime\":\"1514997059000\",\"pubnumber\":\"CN106126643B\",\"searchType\":\"402\",\"appnumber\":\"CN201610465909.3\",\"id\":\"44006546\",\"_type\":\"62\",\"title\":\"流式数据的分布式处理方法和装置\",\"patentName\":\"流式数据的分布式处理方法和装置\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2016.06.23\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2018.01.02\",\"applicationPublishNum\":\"CN106126643B\",\"agency\":\"北京英赛嘉华知识产权代理有限责任公司 11204\",\"uni\":\"293818d8d4eff25509a98759f86ec864\",\"inventor\":\"徐瑶;王聪;张云聪;张建伟;黄鑫\",\"agent\":\"王达佐;马晓亚\",\"applicationPublishTime\":\"2018.01.02\",\"patentNum\":\"CN201610465909.3\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/SQ/20180102/201610465909.3/201610465909.gif\",\"allCatNum\":\"G06F17/30(2006.01)I\",\"abstracts\":\"本申请公开了流式数据的分布式处理方法和装置。所述方法的一具体实施方式包括：将接收到的流式数据封装为第一弹性分布式数据集；按照时间窗口对所述第一弹性分布式数据集执行分组操作，分组操作包括：将第一弹性分布式数据集中的各个数据分别分入该数据所记载的时间戳所属时间窗口所对应的分组中，形成与各个时间窗口分别对应的、包含有穷个数据的第二弹性分布式数据集；将各个第二弹性分布式数据集封装成包含多个第二弹性分布式数据集的嵌套式数据集；使用预先定义的遍历算子，依次将所述嵌套式数据集中的各个第二弹性分布式数据集传递给定义在有穷数据集上的批处理算子以执行分布式数据处理。该实施方式实现了弹性分布式数据集中算子的复用。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"7c6a278ab4a546978e46fcabe91333b0\",\"eventTime\":\"1514822400000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G06F17/27(2006.01)I\",\"createTime\":\"1514996528000\",\"pubnumber\":\"CN107526724A\",\"searchType\":\"402\",\"appnumber\":\"CN201710724703.2\",\"id\":\"43849571\",\"_type\":\"62\",\"title\":\"用于标注语料的方法及装置\",\"patentName\":\"用于标注语料的方法及装置\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2017.08.22\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2017.12.29\",\"applicationPublishNum\":\"CN107526724A\",\"agency\":\"北京英赛嘉华知识产权代理有限责任公司 11204\",\"uni\":\"c53f04986923b4d0633618f27435d294\",\"inventor\":\"孙叔琦;孙珂;赵世奇\",\"agent\":\"王达佐;马晓亚\",\"applicationPublishTime\":\"2017.12.29\",\"patentNum\":\"CN201710724703.2\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/FM/20171229/201710724703.2/201710724703.gif\",\"allCatNum\":\"G06F17/27(2006.01)I\",\"abstracts\":\"本申请实施例公开了用于标注语料的方法及装置。该方法的一具体实施方式包括：从待处理文件中提取待处理文字信息；通过语料标注短语和/或预先训练的语料标注模型为上述待处理文字信息中的语料设置标注信息，其中，语料标注短语用于对文字信息进行初次语料标注，包括语料和语料的标注信息，上述标注信息包括以下至少一项：词性、语序、语法成分、所属语料类别，上述语料标注模型用于对文字信息进行二次语料标注。该实施方式通过语料标注短语对待处理文字信息包含的语料进行语料标注，提高了语料标注的效率；之后，再通过语料标注模型对无法通过语料标注短语标注的语料进行语料标注，提高了标注语料的效率和准确性。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"d1fa4c9612ac485989613d8ce71ef052\",\"eventTime\":\"1514476800000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"F24F5/00(2006.01)I\",\"createTime\":\"1514996884000\",\"pubnumber\":\"CN107525184A\",\"searchType\":\"402\",\"appnumber\":\"CN201710993283.8\",\"id\":\"43935487\",\"_type\":\"62\",\"title\":\"基于数据中心余热的供能系统\",\"patentName\":\"基于数据中心余热的供能系统\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2017.10.23\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2017.12.29\",\"applicationPublishNum\":\"CN107525184A\",\"agency\":\"北京英赛嘉华知识产权代理有限责任公司 11204\",\"uni\":\"a6e07547f39f8c460451f49d2af488b5\",\"inventor\":\"王宇昂;李孝众;张炳华\",\"agent\":\"王达佐;马晓亚\",\"applicationPublishTime\":\"2017.12.29\",\"patentNum\":\"CN201710993283.8\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/FM/20171229/201710993283.8/201710993283.gif\",\"allCatNum\":\"F24F5/00(2006.01)I;F24F13/30(2006.01)I;H05K7/20(2006.01)I\",\"abstracts\":\"本申请实施例公开了基于数据中心余热的供能系统。该数据中心包括制冷系统，用于向数据中心的用冷末端提供冷量。该供能系统的一具体实施方式包括：供热系统，用于向目标用热末端提供热量；余热回收系统，与制冷系统的回液管路和供热系统的回液管路连接，以使制冷系统中的冷却液体与所述供热系统的循环液体进行热交换。该实施方式可以实现制冷系统的回液管路中的高温冷却液体与供热系统中的回液管路中的低温循环液体之间的热交换，即利用冷却液体的余热来提高循环液体的温度，同时可以降低冷却液体的温度。从而提高数据中心能源的利用效率，降低能耗。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"268f9925975947eca003d3da98d31655\",\"eventTime\":\"1514476800000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G06F17/30(2006.01)I\",\"createTime\":\"1514995724000\",\"pubnumber\":\"CN107526809A\",\"searchType\":\"402\",\"appnumber\":\"CN201710727762.5\",\"id\":\"43848610\",\"_type\":\"62\",\"title\":\"基于人工智能推送音乐的方法和装置\",\"patentName\":\"基于人工智能推送音乐的方法和装置\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2017.08.23\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2017.12.29\",\"applicationPublishNum\":\"CN107526809A\",\"agency\":\"北京英赛嘉华知识产权代理有限责任公司 11204\",\"uni\":\"0002a94c3e0281c115383d6879db4e96\",\"inventor\":\"张寅;徐威;黄永祥;凌光;周超\",\"agent\":\"王达佐;马晓亚\",\"applicationPublishTime\":\"2017.12.29\",\"patentNum\":\"CN201710727762.5\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/FM/20171229/201710727762.5/201710727762.gif\",\"allCatNum\":\"G06F17/30(2006.01)I;G06F17/27(2006.01)I\",\"abstracts\":\"本申请实施例公开了基于人工智能推送音乐的方法和装置。方法的一具体实施方式包括：采用字典树服务模板解析用户查询，获取预定字段的值；基于同义词表，获取对应预定字段的值的同义数据集；基于同义数据集，从解析词典中确定推荐解析模板；推送对应推荐解析模板的音乐。该实施方式提高了对用户的多样性表达的识别能力。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"24f1caf748b94525948374040fbb9b3c\",\"eventTime\":\"1514476800000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G06K9/62(2006.01)I\",\"createTime\":\"1514997544000\",\"pubnumber\":\"CN103366178B\",\"searchType\":\"402\",\"appnumber\":\"CN201210091353.8\",\"id\":\"43861131\",\"_type\":\"62\",\"title\":\"一种用于对目标图像进行颜色分类的方法与设备\",\"patentName\":\"一种用于对目标图像进行颜色分类的方法与设备\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2012.03.30\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2017.12.29\",\"applicationPublishNum\":\"CN103366178B\",\"agency\":\"北京汉昊知识产权代理事务所(普通合伙) 11370\",\"uni\":\"0e5f35945effed31deb1b739acbc5572\",\"inventor\":\"文林福\",\"agent\":\"罗朋;周建华\",\"applicationPublishTime\":\"2017.12.29\",\"patentNum\":\"CN201210091353.8\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/SQ/20171229/201210091353.8/201210091353.gif\",\"allCatNum\":\"G06K9/62(2006.01)I;G06T7/90(2017.01)I\",\"abstracts\":\"本发明的目的是提供一种用于对目标图像进行颜色分类的方法与设备。具体地，本发明通过将HSV颜色空间划分成多个颜色子空间，根据所述目标图像在所述HSV颜色空间下的HSV赋值，确定所述目标图像中部分或全部像素与所述多个颜色子空间的映射关系，以确定所述部分或全部像素的颜色分类，根据所述部分或全部像素的颜色分类，确定所述目标图像的颜色分类，解决了现有方法不能适用于各种不同应用场景的问题，提高颜色分类方法的准确性，进一步的提高目标图像的颜色分类方法效率和用户的使用体验。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"80d1d9e271b249838d5b92bb3aa58951\",\"eventTime\":\"1514476800000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G06F17/30(2006.01)I\",\"createTime\":\"1514996187000\",\"pubnumber\":\"CN107526769A\",\"searchType\":\"402\",\"appnumber\":\"CN201710555149.X\",\"id\":\"44003465\",\"_type\":\"62\",\"title\":\"基于人工智能的照片处理方法及装置、设备及可读介质\",\"patentName\":\"基于人工智能的照片处理方法及装置、设备及可读介质\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2017.07.10\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2017.12.29\",\"applicationPublishNum\":\"CN107526769A\",\"agency\":\"北京鸿德海业知识产权代理事务所(普通合伙) 11412\",\"uni\":\"1bc00ce120cf987bd8e02e3040d3edab\",\"inventor\":\"王知践\",\"agent\":\"袁媛\",\"applicationPublishTime\":\"2017.12.29\",\"patentNum\":\"CN201710555149.X\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/FM/20171229/201710555149.X/201710555149.gif\",\"allCatNum\":\"G06F17/30(2006.01)I;G06K9/62(2006.01)I\",\"abstracts\":\"本发明提供一种基于人工智能的照片处理方法及装置、设备及可读介质。其方法包括：接收用户的至少一个查询类别的照片查询请求；根据至少一个照片查询类别，从照片库的知识图谱关系网中查询符合至少一个照片查询类别的目标照片的索引；根据目标照片的索引从照片库中获取对应的目标照片。本发明的技术方案，由于设置有照片库对应的知识图谱关系，对照片库中的照片进行更多类别的分类和管理，这样，可以根据至少一个照片查询类别，可以从照片库的知识图谱关系网中查询符合至少一个照片查询类别的目标照片的索引，然后根据目标照片的索引从照片库中获取对应的目标照片。与现有技术相比，查询照片更加省时省力，从而能够有效地提高照片的查询效率。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"c52fafb7b1f64e8f80eaa01ab595ed3e\",\"eventTime\":\"1514476800000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G06F17/27(2006.01)I\",\"createTime\":\"1514996418000\",\"pubnumber\":\"CN107526725A\",\"searchType\":\"402\",\"appnumber\":\"CN201710787262.0\",\"id\":\"43926542\",\"_type\":\"62\",\"title\":\"基于人工智能的用于生成文本的方法和装置\",\"patentName\":\"基于人工智能的用于生成文本的方法和装置\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2017.09.04\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2017.12.29\",\"applicationPublishNum\":\"CN107526725A\",\"agency\":\"北京英赛嘉华知识产权代理有限责任公司 11204\",\"uni\":\"417d6740cc7b4f8ec97ca2d669e3183e\",\"inventor\":\"刘毅\",\"agent\":\"王达佐;马晓亚\",\"applicationPublishTime\":\"2017.12.29\",\"patentNum\":\"CN201710787262.0\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/FM/20171229/201710787262.0/201710787262.gif\",\"allCatNum\":\"G06F17/27(2006.01)I\",\"abstracts\":\"本申请实施例公开了基于人工智能的用于生成文本的方法和装置。该方法的一具体实施方式包括：获取待扩展文本；切分待扩展文本，得到待扩展文本的词序列；根据预先存储的词与标识信息的对应关系，确定与词序列对应的标识信息序列；将所确定的标识信息序列输入预先训练的文本扩展模型，生成扩展后的文本的标识信息序列；根据所生成的标识信息序列和词与标识信息的对应关系，生成扩展后的文本。该实施方式提高了文本生成的多样性。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"a23c9627f48847d08b922464470a17a2\",\"eventTime\":\"1514476800000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"F24F11/00(2006.01)I\",\"createTime\":\"1514997357000\",\"pubnumber\":\"CN104456847B\",\"searchType\":\"402\",\"appnumber\":\"CN201410676082.1\",\"id\":\"43869078\",\"_type\":\"62\",\"title\":\"一种封闭冷通道的方法\",\"patentName\":\"一种封闭冷通道的方法\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2014.11.21\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2017.12.29\",\"applicationPublishNum\":\"CN104456847B\",\"agency\":\"北京品源专利代理有限公司 11332\",\"uni\":\"466d8829a66709f901920128eed8c858\",\"inventor\":\"王智华;徐勇\",\"agent\":\"路凯;胡彬\",\"applicationPublishTime\":\"2017.12.29\",\"patentNum\":\"CN201410676082.1\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/SQ/20171229/201410676082.1/201410676082.gif\",\"allCatNum\":\"F24F11/00(2006.01)I;H05K7/20(2006.01)I;E04H5/02(2006.01)I\",\"abstracts\":\"本发明实施例公开了一种封闭冷通道的方法，所述方法包括：确定机房内的空置场景；确定空置场景所对应的空间封闭方法；采用空间封闭方法封闭机房内的空置场景中的空置空间；其中，空置场景包括：整个模块通道空置、模块通道中未置满机柜和机柜内未置满设备中的至少一个。通过本发明公开的一种封闭冷通道的方法，封闭机房内的各个空置场景，实现完全隔离冷通道和热通道，防止冷气和热气混合，提高了机房的降温效果，降低机房降温能耗。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"a50c6daf7f97418d9bb1b905d6994d3c\",\"eventTime\":\"1514476800000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G06F17/24(2006.01)I\",\"createTime\":\"1514996072000\",\"pubnumber\":\"CN107526718A\",\"searchType\":\"402\",\"appnumber\":\"CN201710848219.0\",\"id\":\"43957664\",\"_type\":\"62\",\"title\":\"用于生成文本的方法和装置\",\"patentName\":\"用于生成文本的方法和装置\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2017.09.19\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2017.12.29\",\"applicationPublishNum\":\"CN107526718A\",\"agency\":\"北京英赛嘉华知识产权代理有限责任公司 11204\",\"uni\":\"f14678ed6dfd993d901080c59648cc43\",\"inventor\":\"刘凯;霍华荣;吕雅娟\",\"agent\":\"王达佐;马晓亚\",\"applicationPublishTime\":\"2017.12.29\",\"patentNum\":\"CN201710848219.0\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/FM/20171229/201710848219.0/201710848219.gif\",\"allCatNum\":\"G06F17/24(2006.01)I;G06F17/30(2006.01)I\",\"abstracts\":\"本申请实施例公开了用于生成文本的方法和装置。该方法的一具体实施方式包括：获取至少两个目标文本集合；确定目标文本集合两两之间的排列次序和关联程度值；构建包括有向边和结点的加权有向图；在加权有向图中提取由至少一条有向边和由至少一条有向边连接的结点组成的连续路径作为目标路径；分别提取目标路径中各个结点所对应的目标文本集合的摘要，并将提取的各个摘要合并为目标生成文本。该实施方式实现了在不使用模板的情况下利用利用非结构化的原始文本生成最终文本，扩大了自动生成文本方法的适用范围。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"bd59457aa5e34ef586dcfc93a16bc300\",\"eventTime\":\"1514476800000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G06F17/28(2006.01)I\",\"createTime\":\"1514392824000\",\"pubnumber\":\"CN102650988B\",\"searchType\":\"402\",\"appnumber\":\"CN201110046306.7\",\"id\":\"43358015\",\"_type\":\"62\",\"title\":\"一种基于目标语言复述资源的机器翻译方法及装置\",\"patentName\":\"一种基于目标语言复述资源的机器翻译方法及装置\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2011.02.25\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2017.12.26\",\"applicationPublishNum\":\"CN102650988B\",\"agency\":\"北京鸿德海业知识产权代理事务所(普通合伙) 11412\",\"uni\":\"943c6c68a4e5fa4346ce076c5732cb59\",\"inventor\":\"吴华;赵世奇;王海峰\",\"agent\":\"袁媛\",\"applicationPublishTime\":\"2017.12.26\",\"patentNum\":\"CN201110046306.7\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/SQ/20171226/201110046306.7/201110046306.gif\",\"allCatNum\":\"G06F17/28(2006.01)I\",\"abstracts\":\"本发明提供了一种基于目标语言复述资源的机器翻译方法，包括：获取N?Best个翻译结果，所述翻译结果由翻译片段组成；选取所述翻译结果的难翻译片段；根据目标语言的复述资源对所述难翻译片段进行扩展，以得到候选翻译结果集合；对所述的候选翻译结果集合进行评分，以得到最佳翻译结果，通过上述方式，可以部分解决双语翻译资源匮乏的问题，有效地提高机器翻译的流利度，从而提高机器翻译的质量。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"3dc0456f41524209ae479e32a76c5302\",\"eventTime\":\"1514217600000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G06F17/30(2006.01)I\",\"createTime\":\"1514392881000\",\"pubnumber\":\"CN103440286B\",\"searchType\":\"402\",\"appnumber\":\"CN201310354183.2\",\"id\":\"43508665\",\"_type\":\"62\",\"title\":\"一种基于搜索结果来提供推荐信息的方法及装置\",\"patentName\":\"一种基于搜索结果来提供推荐信息的方法及装置\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2013.08.14\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2017.12.26\",\"applicationPublishNum\":\"CN103440286B\",\"agency\":\"北京汉昊知识产权代理事务所(普通合伙) 11370\",\"uni\":\"18954c852547fc41d599628e21782851\",\"inventor\":\"梁博;李晓东;刘荣汉\",\"agent\":\"罗朋\",\"applicationPublishTime\":\"2017.12.26\",\"patentNum\":\"CN201310354183.2\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/SQ/20171226/201310354183.2/201310354183.gif\",\"allCatNum\":\"G06F17/30(2006.01)I\",\"abstracts\":\"本发明公开了一种基于搜索结果来提供推荐信息的方法及装置，其中方法包括：接收来自用户设备的查询序列；根据所述查询序列进行查询，获得包括热点事件的一个或多个搜索结果；根据所述热点事件，在预先建立的热点事件与推荐信息的对应关系库中进行查询，获得所述热点事件相对应的推荐信息；将所述推荐信息与所述一个或多个搜索结果提供给该用户设备。本发明在根据来自用户设备的查询序列，提供给用户设备包括热点事件的一个或多个搜索结果以外，还根据预先建立的热点事件与推荐信息的对应关系，获取该热点事件对应的推荐信息，来提供给用户设备，实现了为用户提供用户隐含期望的搜索结果。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"609b811c10de46aa96b9780edba2228e\",\"eventTime\":\"1514217600000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G06F17/28(2006.01)I\",\"createTime\":\"1514393241000\",\"pubnumber\":\"CN103955454B\",\"searchType\":\"402\",\"appnumber\":\"CN201410104024.1\",\"id\":\"43274803\",\"_type\":\"62\",\"title\":\"一种在白话文与文言文之间进行文体转换的方法和设备\",\"patentName\":\"一种在白话文与文言文之间进行文体转换的方法和设备\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2014.03.19\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2017.12.26\",\"applicationPublishNum\":\"CN103955454B\",\"agency\":\"北京汉昊知识产权代理事务所(普通合伙) 11370\",\"uni\":\"e5271a22c176aa196f61a42dc76b4dca\",\"inventor\":\"马艳军;和为;刘伟;吴礼文;李伟;刘璇;吴华;王海峰\",\"agent\":\"罗朋;周建华\",\"applicationPublishTime\":\"2017.12.26\",\"patentNum\":\"CN201410104024.1\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/SQ/20171226/201410104024.1/201410104024.gif\",\"allCatNum\":\"G06F17/28(2006.01)I\",\"abstracts\":\"本发明的目的是提供一种用于在白话文与文言文之间进行文体转换的方法与设备；获取用户输入的白话文；根据所述白话文，基于翻译模型，并结合文言文属性信息，将所述白话文转换成与之对应的文言文；将所述文言文提供给所述用户。与现有技术相比，本发明满足了用户在白话文与文言文之间进行文体转换的需求，提升了用户的使用体验。进一步地，本发明还可以由用户选择所需转换的文言文文体，结合该文言文文体所对应的文言文属性信息，将用户输入的白话文转换成与之对应的文言文，更进一步提升了用户的使用体验。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"df22492928c54890a1c0a267a8bcd020\",\"eventTime\":\"1514217600000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"H04L12/24(2006.01)I\",\"createTime\":\"1514392936000\",\"pubnumber\":\"CN104539448B\",\"searchType\":\"402\",\"appnumber\":\"CN201410778853.8\",\"id\":\"43767506\",\"_type\":\"62\",\"title\":\"一种用于采集交换机信息的方法、采集单元和系统\",\"patentName\":\"一种用于采集交换机信息的方法、采集单元和系统\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2014.12.15\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2017.12.26\",\"applicationPublishNum\":\"CN104539448B\",\"agency\":\"北京汉昊知识产权代理事务所(普通合伙) 11370\",\"uni\":\"8cd717780428ba184ec3be9ddf1668d0\",\"inventor\":\"王志;谢瑞俊;熊亚军\",\"agent\":\"罗朋\",\"applicationPublishTime\":\"2017.12.26\",\"patentNum\":\"CN201410778853.8\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/SQ/20171226/201410778853.8/201410778853.gif\",\"allCatNum\":\"H04L12/24(2006.01)I;H04L12/931(2013.01)I\",\"abstracts\":\"本发明提供了一种在计算机系统中用于采集并存储交换机信息的方法，该方法包括：所述至少一个采集单元中的每个采集单元根据交换机的被采集项的标识信息，采集所述交换机的交换机信息，并将所述交换机信息提供给所述分配单元；对于每个接收到的交换机信息，所述分配单元根据所述交换机信息，确定与该交换机信息对应的存储单元，并将该交换机信息发送给对应的存储单元；所述至少一个存储单元中的每个存储单元对接收到的交换机信息进行存储。根据本发明的方案，在采集并存储交换机信息的过程中，无需考虑交换机的厂商和型号不同而带来的兼容问题。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"5e883e93eb864188beda7119d2560497\",\"eventTime\":\"1514217600000\",\"applicantName\":\"北京百度网讯科技有限公司\"},{\"mainCatNum\":\"G06K9/00(2006.01)I\",\"createTime\":\"1514392316000\",\"pubnumber\":\"CN107516090A\",\"searchType\":\"402\",\"appnumber\":\"CN201710811916.9\",\"id\":\"43397118\",\"_type\":\"62\",\"title\":\"一体化人脸识别方法和系统\",\"patentName\":\"一体化人脸识别方法和系统\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"applicationTime\":\"2017.09.11\",\"applicantname\":\"[\r\n  '北京百度网讯科技有限公司'\r\n]\",\"patentType\":\"发明专利\",\"pubDate\":\"2017.12.26\",\"applicationPublishNum\":\"CN107516090A\",\"agency\":\"北京英赛嘉华知识产权代理有限责任公司 11204\",\"uni\":\"0a1209b5029ca9ffe46153ea133b6634\",\"inventor\":\"许天涵;张发恩;周恺;王倩;刘昆;肖远昊;徐东泽;孙家元;刘岚\",\"agent\":\"王达佐;马晓亚\",\"applicationPublishTime\":\"2017.12.26\",\"patentNum\":\"CN201710811916.9\",\"imgUrl\":\"http://pic.cnipr.com:8080/XmlData/FM/20171226/201710811916.9/201710811916.gif\",\"allCatNum\":\"G06K9/00(2006.01)I;H04L29/06(2006.01)I;G06F17/30(2006.01)I;H04L29/08(2006.01)I\",\"abstracts\":\"本申请公开了一体化人脸识别方法和系统。该方法的一具体实施方式包括：接收用户的终端发送的一体化人脸识别服务获取请求，一体化人脸识别服务获取请求包括：用户选取的属于所述用户的与人脸识别相关的模型的标识，用户从候选操作中选取的操作的标识；分布式地对用户选取的属于用户的与人脸识别相关的模型执行用户从候选操作中选取的操作，得到操作结果，以及存储操作结果。实现了用户无需购买硬件和搭建软件环境的情况下，利用服务器提供的满足各种与人脸识别相关的需求的硬件资源和搭建的软件环境完成模型的训练、人脸识别应用的开发等操作，节省了开发成本和提升了使用人脸识别服务的便利性。\",\"address\":\"100085 北京市海淀区上地十街10号百度大厦2层\",\"uuid\":\"d0903819f21c423e9cef551843b84c95\",\"eventTime\":\"1514217600000\",\"applicantName\":\"北京百度网讯科技有限公司\"}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open440PatentsDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open440PatentsDTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open440PatentsDTO>> rtnDTO = new BaseRespnseDTO<List<Open440PatentsDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String message = dtos.getMessage();
		BaseRespnseDTO<List<Open440PatentsDTO>> rtnDTO = new BaseRespnseDTO<List<Open440PatentsDTO>>();
		rtnDTO.setRtnSerialNo(uuid);
		rtnDTO.setCode(status);
		rtnDTO.setMsg(message);
		rtnDTO.setRespStr(apiData);
		// 如果查询不成功或者结果是成功无数据，那么直接返回查询失败
		if (TcxyApiStatusCodeEnum.SUCCESS.key() != status && TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() != status) { // 非正常情况
			rtnDTO.setRemark("查询失败");
			return rtnDTO;
		}
		// 更新状态
		String entName = param.getName();
		
		// 先删除 在新增
		entPatentsInfoService.deleteByEntName(entName);
		// 节点数据为空
		ResponsePageNumResultDTO<Open440PatentsDTO> data = dtos.getData();
		if (null == data) {
			logger.error("[{}]data节点数据返回为空", param.getSeqNum());
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			return rtnDTO;
		}
		// 查询成功无数据
		if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) {
			rtnDTO.setRemark("查询成功无数据");
			return rtnDTO;
		}
		// 保存数据
		List<Open440PatentsDTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}


		List<EntPatentsInfoEntity> entityList = Lists.newArrayList();
		List<String> connLs = null;
		EntPatentsInfoEntity entity = null;
		String connStr = null;
		for (Open440PatentsDTO item : items) {
			entity = new EntPatentsInfoEntity();
			BeanUtils.copyProperties(item, entity);

			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());

			connLs = item.getConnList();
			if (null != connLs && connLs.size() >= 1) {
				connStr = Joiner.on(",").join(connLs);
				entity.setConnList(connStr);
			}
			entityList.add(entity);
		}
		entPatentsInfoService.insertBatch(entityList);

		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}