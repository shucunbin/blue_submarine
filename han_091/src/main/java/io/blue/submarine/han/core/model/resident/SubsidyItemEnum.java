package io.blue.submarine.han.core.model.resident;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 补助项目枚举类.
 *
 * @author shucunbin
 * @date 2022-02-06 16:53
 */
@Getter
public enum SubsidyItemEnum {
    /**
     * 草畜平衡奖励资金
     */
    SUBSIDY_ITEM_001("草畜平衡奖励资金", "生态补偿金"),
    SUBSIDY_ITEM_002("草原禁牧补助资金", "生态补偿金"),
    SUBSIDY_ITEM_003("城乡低保(城市低保)", "低保金"),
    SUBSIDY_ITEM_004("城乡低保(城市低保)价格临时补贴", "其他转移性收入"),
    SUBSIDY_ITEM_005("城乡低保(农村低保)", "低保金"),
    SUBSIDY_ITEM_006("城乡低保(农村低保)价格临时补贴", "其他转移性收入"),
    SUBSIDY_ITEM_007("城乡医疗救助", "帮扶"),
    SUBSIDY_ITEM_008("大学生创业补贴", "帮扶"),
    SUBSIDY_ITEM_009("大中型水库移民后期扶持资金", "其他转移性收入"),
    SUBSIDY_ITEM_010("稻谷补贴", "其他转移性收入"),
    SUBSIDY_ITEM_011("地质灾害避险搬迁安置", "帮扶"),
    SUBSIDY_ITEM_012("地质灾害群测群防人员补助资金", "工资性收入"),
    SUBSIDY_ITEM_013("独生子女父母奖励", "计划生育金"),
    SUBSIDY_ITEM_014("高龄老人生活补助", "其他转移性收入"),
    SUBSIDY_ITEM_015("耕地地力保护补贴资金", "其他转移性收入"),
    SUBSIDY_ITEM_016("公路建设土地补偿资金", "财产性收入"),
    SUBSIDY_ITEM_017("孤儿基本生活费", "其他转移性收入"),
    SUBSIDY_ITEM_018("孤儿价格临时补贴", "其他转移性收入"),
    SUBSIDY_ITEM_019("集体和个人天然商品林停伐管护补助", "生态补偿金"),
    SUBSIDY_ITEM_020("计划生育安环补助", "帮扶"),
    SUBSIDY_ITEM_021("计划生育家庭特别扶助", "计划生育金"),
    SUBSIDY_ITEM_022("建档立卡贫困家庭本专科(含高职)学生特别资助", "帮扶"),
    SUBSIDY_ITEM_023("建档立卡贫困家庭中职(含技工)学生特别资助", "帮扶"),
    SUBSIDY_ITEM_024("教育扶贫救助基金", "帮扶"),
    SUBSIDY_ITEM_025("精简退职职工救助", "其他转移性收入"),
    SUBSIDY_ITEM_026("困难残疾人生活补贴", "其他转移性收入"),
    SUBSIDY_ITEM_027("领取失业保险金人员价格临时补贴", "帮扶"),
    SUBSIDY_ITEM_028("农村部分计划生育家庭奖励扶助", "计划生育金"),
    SUBSIDY_ITEM_029("农村危房改造补助资金", "帮扶"),
    SUBSIDY_ITEM_030("农机具购置补贴资金", "其他转移性收入"),
    SUBSIDY_ITEM_031("贫困村公益性岗位补贴", "工资性收入"),
    SUBSIDY_ITEM_032("普通高中助学金", "帮扶"),
    SUBSIDY_ITEM_033("三老人员补贴", "其他转移性收入"),
    SUBSIDY_ITEM_034("森林抚育补助资金", "生态补偿金"),
    SUBSIDY_ITEM_035("森林生态效益补偿资金", "生态补偿金"),
    SUBSIDY_ITEM_036("山洪灾害监测责任人报酬", "工资性收入"),
    SUBSIDY_ITEM_037("少生快富", "计划生育金"),
    SUBSIDY_ITEM_038("失业保险金", "帮扶"),
    SUBSIDY_ITEM_039("事实无人抚养儿童价格临时补贴", "其他转移性收入"),
    SUBSIDY_ITEM_040("事实无人抚养儿童生活补助", "其他转移性收入"),
    SUBSIDY_ITEM_041("特困人员供养", "特困供养金"),
    SUBSIDY_ITEM_042("特困人员价格临时补贴", "特困供养金"),
    SUBSIDY_ITEM_043("特殊困难儿童补助", "其他转移性收入"),
    SUBSIDY_ITEM_044("卫生扶贫救助基金", "帮扶"),
    SUBSIDY_ITEM_045("新一轮退耕还林补助", "生态补偿金"),
    SUBSIDY_ITEM_046("优抚对象补助", "其他转移性收入"),
    SUBSIDY_ITEM_047("优抚对象价格临时补贴", "其他转移性收入"),
    SUBSIDY_ITEM_048("渔业油补资金", "其他转移性收入"),
    SUBSIDY_ITEM_049("中职助学金", "帮扶"),
    SUBSIDY_ITEM_050("重度残疾人护理补贴", "其他转移性收入"),
    SUBSIDY_ITEM_051("自然灾害补助", "其他转移性收入"),
    SUBSIDY_ITEM_052("残疾人扶贫对象生活补贴", "其他转移性收入"),
    SUBSIDY_ITEM_053("出租车油料补贴资金", "帮扶"),
    SUBSIDY_ITEM_054("东西部劳务协作（佛山）稳岗补助", "工资性收入"),
    SUBSIDY_ITEM_055("建档立卡贫困户生态护林员补助", "工资性收入"),
    SUBSIDY_ITEM_056("困难群众临时生活救助", "其他转移性收入"),
    SUBSIDY_ITEM_057("民族地区退耕还林粮食补贴资金", "其他转移性收入"),
    SUBSIDY_ITEM_058("农村道路客运油料补贴资金", "帮扶"),
    SUBSIDY_ITEM_059("农村沼气建设补助资金", "帮扶"),
    SUBSIDY_ITEM_060("普通高中助学金_一", "帮扶"),
    SUBSIDY_ITEM_061("退牧还草工程", "生态补偿金"),
    SUBSIDY_ITEM_062("退役安置补助", "帮扶"),
    SUBSIDY_ITEM_063("完善退耕还林政策补助", "生态补偿金"),
    SUBSIDY_ITEM_064("新一轮退耕还草补贴资金", "生态补偿金"),
    SUBSIDY_ITEM_065("义务兵优待金", "帮扶"),
    SUBSIDY_ITEM_066("草原补奖绩效项目资金", "帮扶"),
    SUBSIDY_ITEM_067("集中连片特困地区9+3生活补助", "帮扶"),
    SUBSIDY_ITEM_068("农村危房改造项目", "帮扶"),
    SUBSIDY_ITEM_069("彝家新寨住房建设资金", "帮扶"),
    SUBSIDY_ITEM_070("易地扶贫搬迁资金(平台公司承接)", "帮扶"),
    SUBSIDY_ITEM_071("易地扶贫搬迁资金住房补助部分", "帮扶"),
    SUBSIDY_ITEM_072("残疾人办证补贴", "帮扶"),
    SUBSIDY_ITEM_073("普通高中助学金_二", "帮扶"),
    SUBSIDY_ITEM_074("普通高中助学金_三", "帮扶"),
    SUBSIDY_ITEM_075("退役军人困难帮扶金", "其他转移性收入"),
    SUBSIDY_ITEM_076("新一轮退耕还林工程种苗款", "生态补偿金"),
    SUBSIDY_ITEM_077("幸福美丽新村建设农户补助", "帮扶"),
    SUBSIDY_ITEM_078("义务教育寄宿制学生生活补助", "帮扶"),
    SUBSIDY_ITEM_079("优抚对象医疗救助", "帮扶"),
    SUBSIDY_ITEM_080("支攀民兵生活补助", "其他转移性收入"),
    SUBSIDY_ITEM_081("寄宿制扩面生生活费补助", "帮扶"),
    SUBSIDY_ITEM_082("普通高中助学金_四", "帮扶"),
    SUBSIDY_ITEM_083("失地农民生活补助", "其他转移性收入"),
    SUBSIDY_ITEM_084("雨露计划补助", "帮扶"),
    SUBSIDY_ITEM_085("残疾人公益岗位补贴", "工资性收入"),
    SUBSIDY_ITEM_086("城市公交油料补贴资金", "帮扶"),
    SUBSIDY_ITEM_087("城乡建设用地增减挂钩项目", "帮扶"),
    SUBSIDY_ITEM_088("高中寄宿制生活补助", "帮扶"),
    SUBSIDY_ITEM_089("公益性岗位补贴资金(人社局)", "工资性收入"),
    SUBSIDY_ITEM_090("建档立卡贫困户脱贫奔康产业发展激励奖补", "帮扶"),
    SUBSIDY_ITEM_091("残疾人扶残助学", "帮扶"),
    SUBSIDY_ITEM_092("残疾人机动车燃油补贴", "帮扶"),
    SUBSIDY_ITEM_093("残疾人居家灵活就业直接补贴", "其他转移性收入"),
    SUBSIDY_ITEM_094("城乡医疗救助(农村)", "帮扶"),
    SUBSIDY_ITEM_095("春蕾计划女童助学金", "帮扶"),
    SUBSIDY_ITEM_096("慈善福彩帮困助学金", "帮扶"),
    SUBSIDY_ITEM_097("非隐患重点监控区监测补助资金", "工资性收入"),
    SUBSIDY_ITEM_098("高速公路征地补偿资金", "财产性收入"),
    SUBSIDY_ITEM_099("公益性水利工程巡管员补助", "工资性收入"),
    SUBSIDY_ITEM_100("廉租房补贴", "其他转移性收入"),
    SUBSIDY_ITEM_101("农村土坯房改造资金", "帮扶"),
    SUBSIDY_ITEM_102("三四级残疾人生活护理费用补贴", "其他转移性收入"),
    SUBSIDY_ITEM_103("水库影响区群测群防专职监测员补助", "工资性收入"),
    SUBSIDY_ITEM_104("一户多残、老残一体救助", "其他转移性收入"),
    SUBSIDY_ITEM_105("正常离职村干部补助", "帮扶"),
    SUBSIDY_ITEM_106("边缘户住房改造补助", "帮扶"),
    SUBSIDY_ITEM_107("残疾人公益岗位工资", "工资性收入"),
    SUBSIDY_ITEM_108("活动室征地补偿费", "财产性收入"),
    SUBSIDY_ITEM_109("建档立卡贫困户缺乏电视机以奖代补", "其他转移性收入"),
    SUBSIDY_ITEM_110("长效节育措施奖励金", "帮扶"),
    SUBSIDY_ITEM_111("安全住房补短板项目", "帮扶"),
    SUBSIDY_ITEM_112("公益性岗位补助（扶贫开发局）", "工资性收入"),
    SUBSIDY_ITEM_113("农牧产业扶贫资金", "帮扶"),
    SUBSIDY_ITEM_114("卫星发射基地搬迁遗留问题退耕还林补助资金(仅对冕宁县)", "生态补偿金"),
    SUBSIDY_ITEM_115("新增能繁母猪补贴", "其他转移性收入"),
    SUBSIDY_ITEM_116("藏区新居补助资金", "帮扶"),
    SUBSIDY_ITEM_117("民兵应急分队务工及生活补助", "工资性收入"),
    SUBSIDY_ITEM_118("贫困学生生活补贴", "帮扶"),
    SUBSIDY_ITEM_119("人居环境整治厕所革命项目", "帮扶"),
    SUBSIDY_ITEM_120("领取国家助学金困难学生价格临时补贴", "帮扶"),
    SUBSIDY_ITEM_121("大学生基层就业奖补资金", "帮扶"),
    SUBSIDY_ITEM_122("三类人员危房住房改造补助", "帮扶"),
    SUBSIDY_ITEM_123("公租房补贴", "其他转移性收入"),
    SUBSIDY_ITEM_124("普通高中助学金_八", "帮扶"),
    SUBSIDY_ITEM_125("普通高中助学金_九", "帮扶"),
    SUBSIDY_ITEM_126("普通高中助学金_六", "帮扶"),
    SUBSIDY_ITEM_127("普通高中助学金_七", "帮扶"),
    SUBSIDY_ITEM_128("普通高中助学金_五", "帮扶"),
    SUBSIDY_ITEM_129("邛海及西昌城区周边植被恢复工程坡耕地造林农户补助资金(仅对西昌市、昭觉县、喜德县)", "生态补偿金"),
    SUBSIDY_ITEM_130("严重精神障碍患者监护人补贴", "其他转移性收入"),
    SUBSIDY_ITEM_131("长江禁捕", "帮扶"),
    SUBSIDY_ITEM_132("残疾儿童康复救助", "帮扶"),
    SUBSIDY_ITEM_133("残疾学生教育资助", "帮扶"),
    SUBSIDY_ITEM_134("中职助学金_三", "帮扶"),
    SUBSIDY_ITEM_135("实际种粮农民一次性补贴", "其他转移性收入"),
    SUBSIDY_ITEM_136("义务教育家庭经济困难学生生活补助", "帮扶"),
    SUBSIDY_ITEM_137("退耕还林直补退耕农户资金", "生态补偿金"),
    SUBSIDY_ITEM_138("中职助学金_四", "帮扶"),
    SUBSIDY_ITEM_139("家庭经济困难大学新生入学资助（路费补助）", "帮扶"),
    SUBSIDY_ITEM_140("贫困党员定期补助", "帮扶"),
    SUBSIDY_ITEM_141("居民养老保险", "养老保险金"),
    SUBSIDY_ITEM_142("临时救助金", "帮扶"),
    SUBSIDY_ITEM_143("农村最低生活保障金", "低保金"),
    SUBSIDY_ITEM_144("稻谷补贴（稻谷目标价格补贴资金）", "其他转移性收入"),
    SUBSIDY_ITEM_145("集体和个人所有天然商品林停伐管护补助", "生态补偿金"),
    SUBSIDY_ITEM_146("实际种粮农民（户）一次性补贴", "其他转移性收入"),
    SUBSIDY_ITEM_147("特殊困难儿童资助金", "其他转移性收入"),
    SUBSIDY_ITEM_148("城乡医疗救助资金（实行“一站式”结算的资金除外）", "帮扶"),
    SUBSIDY_ITEM_149("分散养育孤儿和艾滋病病毒感染儿童基本生活费", "其他转移性收入"),
    SUBSIDY_ITEM_150("草原禁牧补助（贴）资金", "生态补偿金"),
    SUBSIDY_ITEM_151("高龄津贴（高龄老人生活补贴）", "其他转移性收入"),
    SUBSIDY_ITEM_152("义务教育家庭经济困难（含寄宿制、非寄宿制）学生生活补助", "帮扶"),
    SUBSIDY_ITEM_153("过渡期生活救助金", "其他转移性收入"),
    SUBSIDY_ITEM_154("乡村公益性岗位（补贴）", "工资性收入"),
    SUBSIDY_ITEM_155("建档立卡中职学生特别补助", "帮扶"),
    SUBSIDY_ITEM_156("易地扶贫搬迁随迁户住房补助资金", "帮扶"),
    SUBSIDY_ITEM_157("建档立卡贫困本专科（含高职）学生特别资助", "帮扶"),
    SUBSIDY_ITEM_158("冬令春荒期间受灾困难群众临时生活救助金", "其他转移性收入"),
    SUBSIDY_ITEM_159("东西部劳务协作（宁波）稳岗补助", "工资性收入"),
    SUBSIDY_ITEM_160("东西部劳务协作（宁波）一次性生活补贴", "工资性收入"),
    SUBSIDY_ITEM_161("农村部分计划生育家庭奖励扶助（资金）", "计划生育金"),
    SUBSIDY_ITEM_162("出栏生猪补贴（生猪出栏补贴）", "其他转移性收入"),
    SUBSIDY_ITEM_163("残疾人扶残助学（残疾学生教育资助）", "帮扶"),
    SUBSIDY_ITEM_164("分散特困人员救助供养金", "特困供养金"),
    SUBSIDY_ITEM_165("计划生育家庭特别扶助（资金）", "计划生育金"),

    ;
    private final String itemName;
    private final String itemType;

    SubsidyItemEnum(String itemName, String itemType) {
        this.itemName = itemName;
        this.itemType = itemType;
    }

    private static final Map<String, String> LOOK_UP = Arrays.stream(SubsidyItemEnum.values())
            .collect(Collectors.toMap(SubsidyItemEnum::getItemName, SubsidyItemEnum::getItemType));

    public static String getTypeByName(String itemName) {
        return LOOK_UP.get(itemName);
    }

}