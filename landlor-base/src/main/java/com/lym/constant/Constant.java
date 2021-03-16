package com.lym.constant;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lghuntfor
 * @since 2018/7/4
 */
public class Constant {

    public static Integer PAGE_SIZE = 15;
    public static Integer PAGE_ROWS_10 = 10;
    public static Integer PAGE_ROWS_15 = 10;
    public static Integer PAGE_ROWS_20 = 10;
    private static final String CHINA_PATTERN = "^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$";
    /** 空格 */
    public static final String SPACE = " ";

    /**
     * 对/错
     */
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String YES = "yes";
    public static final String NO = "no";
    public static final String HTTP = "http://";
    public static final String HTTPS = "https://";

    /**
     * 网店未审核状态
     */
    public static final int SHOP_AUDIT_WAIT = 0;

    /**
     * 网店审核通过状态
     */
    public static final int SHOP_AUDIT_PASS = 1;

    /**
     * 网店审核拒绝状态
     */
    public static final int SHOP_AUDIT_NOPASS = 2;

    /**
     * 字段编码
     */
    public static final String CHARSET_UTF8 = "UTF-8";

    /**
     * 状态常量
     */
    public static final Byte STATUS_FLAG_ZERO = 0;
    public static final Byte STATUS_FLAG_ONE = 1;
    public static final Byte STATUS_FLAG_TWO = 2;
    public static final Byte STATUS_FLAG_THR= 3;
    public static final Byte STATUS_FLAG_FOU = 4;
    public static final Byte STATUS_FLAG_FIVE = 5;
    public static final Byte STATUS_FLAG_SIX = 6;
    public static final Byte STATUS_FLAG_SEVEN = 7;
    public static final Byte STATUS_FLAG_EIGHT = 8;
    public static final Byte STATUS_FLAG_NIEN = 9;
    public static final Byte STATUS_FLAG_TEN= 10;
    public static final Byte STATUS_FLAG_ELEVEN= 11;
    public static final Byte STATUS_FLAG_TWELVE= 12;

    public static final Byte STATUS_FLAG_NEGATWO = -2;
    public static final Byte STATUS_STATUS_NEGATIVE= -1;

    //字符串-2
    public static final String STRING_FLAG_NEGATWO = "-2";

    /**
     * 数字类型常量
     */
    public static final Integer NUMBER_STATUS_ZERO = 0;
    public static final Integer NUMBER_STATUS_ONE = 1;
    public static final Integer NUMBER_STATUS_TWO = 2;
    public static final Integer NUMBER_STATUS_THR = 3;
    public static final Integer NUMBER_STATUS_FOU = 4;
    public static final Integer NUMBER_STATUS_FIVE = 5;
    public static final Integer NUMBER_STATUS_SIX = 6;
    public static final Integer NUMBER_STATUS_SEVEN = 7;
    public static final Integer NUMBER_STATUS_EIGHT = 8;
    public static final Integer NUMBER_STATUS_NIEN = 9;
    public static final Integer NUMBER_STATUS_TEN= 10;
    public static final Integer NUMBER_STATUS_ELEVEN= 11;
    public static final Integer NUMBER_STATUS_TWELVE= 12;
    public static final Integer NUMBER_STATUS_TWETEEN= 13;
    public static final Integer NUMBER_STATUS_TWEFOUT= 14;
    public static final Integer NUMBER_STATUS_TWEFIVE= 15;
    public static final Integer NUMBER_STATUS_SIXTEEN= 16;
    public static final Integer NUMBER_STATUS_SEVENTEEN= 17;
    public static final Integer NUMBER_STATUS_EIGHTEEN= 18;
    public static final Integer NUMBER_STATUS_NIENTEEN= 19;
    public static final Integer NUMBER_STATUS_TWENTY= 20;
    public static final Integer NUMBER_STATUS_TWEONE= 21;
    public static final Integer NUMBER_STATUS_TWETWO= 22;
    public static final Integer NUMBER_STATUS_TWETHR= 23;
    public static final Integer NUMBER_STATUS_TWEFOU= 24;
    public static final Integer NUMBER_STATUS_TYPE_25 = 25;
    public static final Integer NUMBER_STATUS_26 = 26;
    public static final Integer NUMBER_STATUS_TWEEIGHT= 28;
    public static final Integer NUMBER_STATUS_THIRTY= 30;

    public static final Integer NUMBER_STATUS_NEGATIVE= -1;
    //100(整数)
    public static final Integer NUMBER_HUNDRED_THIRTY= 100;

    /**
     * 浮点型常量
     */
    public static final Float FLOAT_STATUS_ZERO = 0F;

    public static final String ROLE_NAME_BROKER = "broker";
    //买卖部业务总监
    public static final String ROLE_NAME_SALE_BUSINESS_DIRECTOR = "area-director-buysell";
    //买卖部总监助理
    public static final String ROLE_NAME_SALE_DIRECTOR_ASSISTANT = "regional-assistant-buysell";
    //买卖部助理
    public static final String ROLE_NAME_SALE_MaiMaiBuZhuLi = "HuoBanChanFu-MaiMaiBuZhuLi";
    //项目经理
    public static final String ROLE_NAME_PROJECT_MANAGER = "HuoBanJingJiRen-XiangMuJingLi";
    //项目助理
    public static final String ROLE_NAME_PROJECT_ASSISTANT = "HuoBanJingJiRen-XiangMuZhuLi";
    //经纪人
    public static final String ROLE_NAME_BRANCH_BROKER = "broker";
    //分行助理
    public static final String ROLE_NAME_BRANCH_ASMANAGER = "area-branch-asmanager";
    //分行经理
    public static final String ROLE_NAME_BRANCH_MANAGER = "area-branch-manager";
    //业务总监
    public static final String ROLE_NAME_YeWuZongJian = "area-director";
    //副总经理
    public static final String ROLE_NAME_FuZongJingLi = "vice-general-manager";
    //买卖部副总经理
    public static final String ROLE_NAME_MaiMaiBuFuZongJingLi = "MaiMaiBuFuZongJingLi";

    //成都区域专员
    public static final String ROLE_NAME_QUYUZHUANYUAN = "QuYuZhuanYuan";
    //成都区域经理
    public static final String ROLE_NAME_QUYUJINGLI = "QuYuJingLi";

    //洗盘部经理
    public static final String ROLE_NAME_BRANCH_XIPANBU = "HuoBanJingJiRen-XiPanBuJingLi";

    //写字楼代理部总监
    public static final String ROLE_NAME_BUILDING_AGENCY_DIRECTOR = "HuoBanJingJiRen-XieZiLouDaiLiBuZongJian";
    //写字楼代理部助理
    public static final String ROLE_NAME_BUILDING_AGENCY_ASSISTANT = "HuoBanJingJiRen-XieZiLouDaiLiBuZhuLi";

    // 分行回款统计报表需要用到的角色
    // 业务管理部总监
    public static final String ROLE_BUSINESS_MANAGER_DIRECTOR = "business-manager-director";
    // 业务管理部
    public static final String ROLE_BUSINESS_MANAGER = "business-manager";
    // 业务管理部-核算
    public static final String ROLE_BUSINESS_CHECK = "business-check";
    // 预算经理
    public static final String ROLE_BUDGET_MANAGER = "budget-manager";
    //财务经理
    public static final String FINANCIAL_MANAGER_ROLE = "finance-manager";
    //财务总监
    public static final String ROLE_FINANCIAL_DIRECTOR = "finance-dirctor";
    //出纳主管
    public static final String CASHIER_MGR = "cashier-mgr";

    public static final String COMPANY_CODE_HUOBANJINGJIREN = "HB-000101";
    //成交确认
    public final static String TRADEREPORT_CONFIRM = "tradeReport_confirm";

    public static final Double STATUS_FLAG_NEGATIVE = -1D;

    public static final BigDecimal NUMBER_PERCENTAGE = new BigDecimal(100);

    public static final Long LONG_NUMBER_ZERO = 0L;

    public static final Long LONG_NUMBER_ONE = 1L;

    public static final Long LONG_NUMBER_SUB_ONE = -1L;
    //除跟进外需要私密处理的消息数组
    public static final Integer[] DYNAMIC_MESSAGE_ARR = new Integer[]{ Constant.NUMBER_STATUS_TWETEEN, Constant.NUMBER_STATUS_TWEFOUT, Constant.NUMBER_STATUS_TWEFIVE,
            Constant.NUMBER_STATUS_SEVENTEEN,Constant.NUMBER_STATUS_THR};
    //能够查看需求信息的消息
    public static final Integer[] DYNAMIC_MESSAGE_NEEDS_TITLE = new Integer[]{Constant.NUMBER_STATUS_TWEFOUT,Constant.NUMBER_STATUS_EIGHTEEN,Constant.NUMBER_STATUS_NIENTEEN,Constant.NUMBER_STATUS_TWENTY
            ,Constant.NUMBER_STATUS_TWEONE,Constant.NUMBER_STATUS_TWETWO,Constant.NUMBER_STATUS_TWETHR,Constant.NUMBER_STATUS_TWEFOU};

    //普通跟进消息
    public static final Integer[] DYNAMIC_MESSAGE_SIM_FOLLOW = new Integer[]{Constant.NUMBER_STATUS_EIGHTEEN};
    //带看跟进消息
    public static final Integer[] DYNAMIC_MESSAGE_WITH_FOLLOW = new Integer[]{Constant.NUMBER_STATUS_NIENTEEN};
    //客户修改
    public static final Integer[] DYNAMIC_MESSAGE_CUSTOMER_FOLLOW = new Integer[]{Constant.NUMBER_STATUS_ONE,Constant.NUMBER_STATUS_TWO,Constant.NUMBER_STATUS_THR
            ,Constant.NUMBER_STATUS_FOU,Constant.NUMBER_STATUS_FIVE,Constant.NUMBER_STATUS_SIX,Constant.NUMBER_STATUS_TWELVE};
    //需求
    public static final Integer[] DYNAMIC_MESSAGE_NEEDS_FOLLOW = new Integer[]{Constant.NUMBER_STATUS_TWETEEN,Constant.NUMBER_STATUS_TWEFOUT};
    //推荐接收
    public static final Integer[] DYNAMIC_MESSAGE_REFER_FOLLOW = new Integer[]{Constant.NUMBER_STATUS_TWEFIVE,Constant.NUMBER_STATUS_SEVENTEEN};
    //超时未跟进发送待办的跟进范围
    public static final Integer[] DYNAMIC_MESSAGE_IM_WAIT_FOLLOW = new Integer[]{2, 14, 15, 18, 19, 20};

    public static final Long CUSTOMER_IDLE_USER_ID = Long.valueOf(-2);

    //待接收 接收
    public static final Integer[] RECOMMEND_CUSTOMER_CLARE = new Integer[]{NUMBER_STATUS_ZERO,NUMBER_STATUS_ONE,NUMBER_STATUS_FIVE,NUMBER_STATUS_SIX};

    //虚拟区域、管理区域的office
    public static final String[] DELETE_AREA_OFFICE = new String[]{"虚拟区域","管理区域", "测试", "虚拟"};

    //空字符串
    public static final String STRING_NULL = "";

    //字符空对象
    public static final String STRING_OBJ_NULL = "null";

    public static final String STRING_MINUS_ONE = "-1";

    public static final String STRING_TWO = "2";

    public static final String STRING_THR = "3";

    public static final String STRING_FOUR = "4";

    public static final String STRING_FIVE = "5";

    public static final String STRING_SIX = "6";

    public static final String STRING_ONE = "1";

    public static final String STRING_ZERO = "0";

    public static final String STRING_EIGHT = "8";

    public static final String BRANCH_MANAGER="area-branch-manager";

    public static final String SYS_MANAGER="sys-manager";

    public static final String MANAGER_CONTACT_SHOW = "customer:info:showFullCustomerContcat";

    public static final BigDecimal BIG_DECIMAL_ZERO = new BigDecimal(0);

    public static final BigDecimal BIG_DECIMAL_INGERONE = new BigDecimal(-1);

    public static final String CUSTOMER_IFFOLLOW_NEEDS = "CUSTOMER:IFFOLLOW:NEEDS:VALUE";

    // 手机验证码
    public static final String SESSION_MOBILE_CODE = "SESSION:MOBILE:CODE:";
    // 是否发送手机验证码标志
    public static final String COOKIDE_VALIDATE_FLAG = "V_";
    // 登陆失败次数
    public static final String LOGIN_FAIL_COUNT = "LOGIN_FAIL_COUNT_";
    // 图片验证码
    public static final String IMAGE_CODE = "IMAGE_CODE_";
    // 信任ip
    public static final String LOGIN_TRUST_IPS = "LOGIN:TRUST:IPS";

    //初始化空
    public static final Double DOUBLE_VALUE_ZERO = 0.000D;

    public static final String INDUSTRIER_MAP_COLLECTION = "INDUSTRIER:MAP:COLLECTION";

    //excel空值
    public static final String EXCEL_NULL = "--";

    //字符 - 集合 分隔符
    public static final String STR_COMMA = ",";
    //中文是
    public static final String STR_TRUE = "是";
    //中文否
    public static final String STR_FALSE = "否";
    //单位亩
    public static final String STR_MU = "亩";
    //单位平方米
    public static final String STR_MI = "m²";
    // 盘源操作记录切割符号
    public static final String SPLIT_SIGN = "|%";
    // 盘源操作记录转义切割符号
    public static final String TRANS_SPLIT_SIGN = "\\|%";
    // 中文冒号
    public static final String CHINESE_COLON = "：";
    //英文引号
    public static final String QUOTATION_MARK ="\"";
    //暂无数据
    public static final String NULL_STRING_DEFUAT = "暂无数据";
    //单字符无
    public static final String NULL_STRING_DEFUAT_SING = "无";
    //单字符有
    public static final String NULL_STRING_HAVE_DEFUAT_SING = "有";
    //手动换行
    public static final String STRING_ENTER_STR = "\n";
    //租
    public static final String RENT = "租";
    //售
    public static final String SALE = "售";
    //元
    public static final String YUAN = "元";
    //单价
    public static final String PRICE_MI = "元/m²";
    // 测试
    public static final String HZ_TEST = "测试";
    // 汇总数
    public static final String HZ_COUNT = "汇总数";

    //系统换行 System.getProperty("line.separator")
    public static final String STRING_ENTER_RNSTR = "line.separator";

    // 洗盘部查看所有数据的权限标志
    public static final String HOUSE_WASH_PERMISSION_ALL = "houseInfo:wash:all";
    // 转移盘方的权限标志
    public static final String HOUSE_EDIT_USER_PERMISSION = "houseInfo:house:editHouseUser";

    //园区详情http路径
    public static final String CUSTOMER_GARDEN_DETAIL_URL = "CUSTOMER:GARDEN:DETAIL:URL";
    //园区详情默认路径
    public static final String CUSTOMER_GARDEN_DETAIL_DEFULT_URL = "https://test.zhaoshang800.com/garden/garden/gardenDetail/";

    /**
     * h5访问时请求header带的来源
     */
    public static final String H5_ACCESS_SOURCE_HEADER_NAME = "s";
    public static final String H5_ACCESS_SOURCE_HEADER_VALUE = "h5";

    //格式化时间字符
    public static String[] parsePatterns = {
            //index 0 - 3
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            //index 4 - 7
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            //index 8 - 11
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM",
            //index 12 - 14
            "yy.MM.dd",   "yyyyMMdd",            "yyyy年MM月dd日"};
    //亩换算成平方米，1亩等于666.67平方米
    public static final BigDecimal MU_CONVERTED_METERS = new BigDecimal("666.67");

    /**
     * 流程流水号
     */
    public static final String PROCESS_SERIAL_NO = "PROCESS:SERIALNO";

    /**
     * 盘源操作日志记录，来源标志
     */
    // 修改盘源状态
    public static final String HOUSE_UPDATE_STATUS = "houseUpdateStatus";
    // 修改买卖盘源状态
    public static final String SELL_HOUSE_STATUS_UPDATE= "sellHouseStatusUpdate";
    // 成交报告审核通过后
    public static final String HOUSE_TRADE_COMPLETE_BACK = "houseTradeCompleteBack";
    // 成交报告特改后
    public static final String HOUSE_TRADE_SPECIAL_UPDATE = "houseTradeSpecialUpdate";
    // 成交报告退单
    public static final String HOUSE_TRADE_CHARGE_BACK = "houseTradeChargeBack";
    // 准单审核通过后
    public static final String HOUSE_DETERMINE_COMPLETE = "houseDetermineComplete";
    // 准单退单审核通过后
    public static final String HOUSE_TRADE_PERMIT_CHARGE_BACK = "houseTradePermitChargeBack";

    //伙伴月12月正月数据展示
    public static final String[] PARTNER_MONTH_BOSS = new String[]{"26日","27日","28日","29日","30日","31日","1日","2日","3日",
            "4日","5日","6日","7日","8日","9日","10日","11日","12日","13日","14日","15日","16日", "17日","18日","19日","20日",
            "21日","22日","23日","24日","25日","26日_","27日_","28日_","29日_","30日_","31日_"};

    //start开始时间名
    public static final String START_TIME_NAME = "startTime";

    public static final String END_TIME_NAME = "endTime";

    public static final String OFFICE_ENNAME = "OFFICE:ENNAME";

    public static final String STRING_STAR = "*";
    /** 字典表下载模板type关键字 */
    public static final String DICT_TYPE_DOWNLOAD_FILE_TEMPLATE = "download_file_template";
    /** 字典表成交报告下载模板label--中介*/
    public static final String TRADEREPORT_DOWNLOAD_TEMPLATE_URL = "TRADEREPORT:DOWNLOAD:TEMPLATEURL";
    /** 字典表成交报告下载模板label--代理*/
    public static final String TRADEREPORT_DOWNLOAD_TEMPLATE_URL_AGENCY = "TRADEREPORT:DOWNLOAD:TEMPLATEURL:AGENCY";
    /** 字典表员工信息下载模板label */
    public static final String EMPLOYEE_DOWNLOAD_TEMPLATE_URL = "EMPLOYEE:DOWNLOAD:TEMPLATEURL";

    /**成交报告入口的控制（中介）*/
    public static final String TRADE_REPORT_OPEN_FLAG = "TRADEREPORT:OPEN_FLAG";
    /** 准单录入（中介）*/
    public static final String TRADE_REPORT_DETERMINE_OPEN_FLAG = "TRADEREPORT:DETERMINE:OPEN_FLAG";
    /** 历史准单录入（中介）*/
    public static final String TRADE_REPORT_HISTORY_DETERMINE_OPEN_FLAG = "TRADEREPORT:HISTORY:DETERMINE:OPEN_FLAG";
    /** 准单转成交报告（中介）*/
    public static final String TRADE_REPORT_DETERMINE_TOTRADE_FLAG = "TRADEREPORT:DETERMINE:TOTRADE_FLAG";
    /**历史成交报告开关（中介）*/
    public static final String TRADE_REPORT_HISTORY_OPEN_FLAG = "TRADEREPORT:HISTORY:OPEN_FLAG";

    /**成交报告入口的控制（代理）*/
    public static final String TRADE_REPORT_OPEN_FLAG_AGENCY = "TRADEREPORT:AGENCY:OPEN_FLAG";
    /** 准单录入（代理）*/
    public static final String TRADE_REPORT_DETERMINE_OPEN_FLAG_AGENCY = "TRADEREPORT:AGENCY:DETERMINE:OPEN_FLAG";
    /** 历史准单录入（代理）*/
    public static final String TRADE_REPORT_HISTORY_DETERMINE_OPEN_FLAG_AGENCY = "TRADEREPORT:AGENCY:HISTORY:DETERMINE:OPEN_FLAG";
    /** 准单转成交报告（代理）*/
    public static final String TRADE_REPORT_DETERMINE_TOTRADE_FLAG_AGENCY = "TRADEREPORT:AGENCY:DETERMINE:TOTRADE_FLAG";
    /**历史成交报告开关（代理）*/
    public static final String TRADE_REPORT_HISTORY_OPEN_FLAG_AGENCY = "TRADEREPORT:AGENCY:HISTORY:OPEN_FLAG";

    /**
     * 成交报告、准单、历史成交报告、历史准单 录入菜单权限
     */
    //成交报告
    public static final String TRADE_REPORT_SAVE = "tradeR:trade:save";
    //历史成交报告
    public static final String TRADE_REPORT_SAVE_HISTORY = "tradeR:trade:saveHistory";
    //准单
    public static final String TRADE_DETERMINE_SAVE = "tradeR:determine:save";
    //历史准单
    public static final String TRADE_DETERMINE_SAVE_HISTORY = "tradeR:determine:saveHistory";

    //成交报告（代理）
    public static final String TRADE_REPORT_SAVE_AGENCY = "tradeR:agency:trade:save";
    //历史成交报告（代理）
    public static final String TRADE_REPORT_SAVE_HISTORY_AGENCY = "tradeR:agency:trade:saveHistory";
    //准单（代理）
    public static final String TRADE_DETERMINE_SAVE_AGENCY = "tradeR:agency:determine:save";
    //历史准单（代理）
    public static final String TRADE_DETERMINE_SAVE_HISTORY_AGENCY = "tradeR:agency:determine:saveHistory";

    /**
     * 成交报告操作菜单权限
     */
    //下载
    public static final String TRADE_REPORT_DOWNLOAD = "tradeR:trade:download";
    // 编辑
    public static final String TRADE_REPORT_UPDATE = "tradeR:trade:update";
    public static final String TRADE_DETERMINE_EDIT = "tradeR:trade:update";
    // 删除
    public static final String TRADE_REPORT_DEL = "tradeR:trade:del";
    public static final String TRADE_DETERMINE_DEL = "tradeR:trade:del";
    // 特改
    public static final String TRADE_DETERMINE_SPECIAL_UPDATE = "tradeR:trade:updateSpecial";
    // 发票特改
    public static final String TRADE_INVOICE_CHANGE = "tradeR:invoice:change";
    // 退单
    public static final String TRADE_REPORT_CHARGEBACK = "tradeR:trade:chargeback";
    // 准单退单
    public static final String TRADE_REPORT_DETERMINE_CHARGEBACK = "tradeR:trade:chargeback";
    // 转成交报告
    public static final String TRADE_DETERMINE_TOTRADE = "tradeR:determine:toTrade";


    /**
     * 认领标识
     */
    public static final String TRADE_REPORT_PROCEEDS_REVOKE_FLAG = "TRADEREPORT:PROCEEDS:REVOKEFLAG:";
    /**
     * 成交报告退单标识
     */
    public static final String DETERMINE_TRADE_CHARGEBACK_FLAG = "DETERMINE:TRADE:CHARGEBACK:FLAG:";
    /**
     * 成交报告退单标识
     */
    public static final String TRADE_CHARGEBACK_FLAG = "TRADE:CHARGEBACK:FLAG:";

    /**
     * 业务线默认id
     */
    public static  Long DEFAULT_TRANSACTIONLINEID = 1000L;

    /**
     * 转换万金额
     */
    public final static BigDecimal TEN_THOUSAND = new BigDecimal("10000");
    /**
     * 百分
     */
    public final static BigDecimal HUNDRED = new BigDecimal("100");

    public final static BigDecimal TWO = new BigDecimal("2");

    /**
     * 机构类型
     */
    public static class OfficeType {
        //集团
        public static final String BIG_GROUP = "0";
        //公司
        public static final String COMPANY = "1";
        //区域
        public static final String AREA = "2";
        //小组
        public static final String SMALL_GROUP = "3";
        //其他
        public static final String OTHER = "4";
        //分行
        public static final String BRANCH = "5";
        //部门
        public static final String DEPARTMENT = "6";
        //片区
        public static final String  ZONE= "7";
        //子公司
        public static final String CHILD_COMPANY = "8";

        public static final Map<String,String> map = new HashMap<>();

        static {
            map.put("0","集团");
            map.put("1","公司");
            map.put("2","区域");
            map.put("3","小组");
            map.put("4","其他");
            map.put("5","分行");
            map.put("6","部门");
            map.put("7","片区");
            map.put("8","子公司");
        }


    }

    /**
     * 区域类型,1-国，2-省，3-市，4-区, 5-镇
     */
    public static class AreaType {
        //国
        public static final Integer COUNTRY = 1;
        //省
        public static final Integer PROVINCE = 2;
        //市
        public static final Integer CITY = 3;
        //区
        public static final Integer AREA = 4;
        //镇
        public static final Integer TOWN = 5;
    }

    /**
     * 网店状态 1-未发布,2-已发布,3-删除
     */
    public static class ShopStatus {

        public static final Integer NOT_PUBLISHED = 1;

        public static final Integer PUBLISHED = 2;

        public static final Integer DELETE = 3;
    }


    /**
     * 账号类型1伙伴经纪人2外地站经纪人3推广用户4加盟商
     */
    public static class AccountType {

        public static final Integer INSIDE_BROKER = 1;

        public static final Integer OUTSIDE_BROKER = 2;

        public static final Integer PROMOTING_USER = 3;

        public static final Integer FRANCHISEE = 4;
    }

    public static class ZgUserStatus {

        public static final Integer INSIDE_BROKER = 1;

        public static final Integer OUTSIDE_BROKER = 2;

        public static final Integer PROMOTING_USER = 3;

        public static final Integer FRANCHISEE = 4;
    }

    /**
     * 盘源状态常量类 0-待租，1-已出租，2-部分出租，3-出租不可推，4-待售，5-已售，6-出售不可推
     */
    public static class HouseStatus {

        public static final int WAIT_RENT = 1;

        public static final int ALREADY_RENT = 2;

        public static final int PART_RENT = 3;

        public static final int WAIT_SELL = 4;

        public static final int ALREADY_SELL = 5;

        public static final int NO_PUSH = 6;
    }

    /**
     * 符号静态常量
     */
    public static class Sign {
        /** 英文逗号 */
        public static final String COMMA_EN = ",";
        /** 中文逗号 */
        public static final String COMMA_CN = "，";
        /** 等于 */
        public static final String EQ_CHAT = "=";
        /** 并字符 */
        public static final String AND_CHAT = "&";
        /** 点 */
        public static final String SPOT = ".";
        /** 横 */
        public static final String TRANSVERSE = "-";
        /** 下滑线 */
        public static final String UNDERLINE = "_";
        /** 中文顿号 */
        public static final String DAWN = "、";
        /** 英文分号 */
        public static final String SEM = ";";
        /** 英文冒号 */
        public static final String COLON_EN = ":";
        /** 中文冒号 */
        public static final String COLON_CN = "：";
        /** 英文左斜线 */
        public static final String LEFT_SLASH = "/";
        /** 百分号 */
        public static final String PERCENT_SIGN = "%";
        /** 左括号 */
        public static final String LEFT_BRACKETS = "（";
        /** 右括号 */
        public static final String RIGHT_BRACKETS  = "）";
        /** 左花括号 */
        public static final String LEFT_FLOWER_BRACKETS = "{";
        /** 右花括号 */
        public static final String RIGHT_FLOWER_BRACKETS  = "}";
        /** 左中括号EN */
        public static final String LEFT_BRACKET_BRACKETS = "[";
        /** 右中括号EN */
        public static final String RIGHT_BRACKET_BRACKETS  = "]";
        /** 左括号En */
        public static final String LEFT_BRACKETS_EN = "(";
        /** 右括号En */
        public static final String RIGHT_BRACKETS_EN  = ")";
        /** 英文单引号 */
        public static final String SINGLE_QUOTATION_EN = "'";
    }

    /**
     * 客户联系方式常量类
     */
    public static class ContactType{
        /** 手机 */
        public static final String MOBILE_PHONE = "0";
        /** 固话 */
        public static final String FIXED_PHONE = "1";
    }

    /**
     * 倒出Excel中选中图标常量类
     */
    public static class CheckedType{
        /** 选中 */
        public static final String CHECKED = "■";
        /** 未选中 */
        public static final String UNCHECKED = "□";
    }

    /**
     * 楼盘常量类
     */
    public static class Build {

        /**
         * 地图找房级别
         */
        public static final String BUILD_LEVEL_ONE = "1";

        /**
         * 地图找房级别
         */
        public static final String BUILD_LEVEL_TWO = "2";

        /**
         * 地图找房级别
         */
        public static final String BUILD_LEVEL_THREE = "3";

    }

    public static class HouseInfoType {

        // 租厂房
        public static final String RENT_FACTORY = "0_0";
        //租写字楼
        public static final String RENT_BUILDING = "0_1";
        //租土地
        public static final String RENT_LAND = "0_2";
        //租住宅/商铺/公寓
        public static final String RENT_SHOPS= "0_3";
        //售厂房
        public static final String SELL_FACTORY = "1_0";
        //售写字楼
        public static final String SELL_BUILDING = "1_1";
        //售土地
        public static final String SELL_LAND = "1_2";
        //售住宅/商铺/公寓
        public static final String SELL_SHOPS= "1_3";

    }

    public static class ProceedsConstant {
        //未认领完成的款项数据
        public static final Byte[] PROCEEDS_STATUS_UNCLAM = new Byte[]{STATUS_FLAG_ZERO,STATUS_FLAG_ONE,STATUS_FLAG_TWO};
    }

    /**
     * 法律文书相关常量
     */
    public static class LegalFile {
        // 查看所有数据的权限标志
        public static final String LEGAL_FILE_LOOK_ALL = "legalFile:look:all";

        // 经纪人法律文书申请流程标志
        public static final String LEGAL_FILE_PROCESS_BROKER = "JingJiRenFaLvWenShuShenQing";

    }


    public static class SkyEye {
        // 客户卡片
        public static final String CUSTOMER_CARD = "customerCard";
        // 成交报告卡片
        public static final String TRADE_CARD = "tradeCard";
        // 成交动作分行分佣方头像地址
        public static final String OFFICE_PHOTO_URL = "https://img.cdn.zhaoshang800.com/img/2019/10/28/broker/2bc48171-3f79-436d-99cb-68273540006a.png";
        //带看跟进占位图
        public static final String TAKE_LOOK_PHOTO_URL = "https://img.cdn.zhaoshang800.com/img/2019/10/31/broker/c33525ff-06bb-4754-88f3-e61f83a874f7.png";
    }
    /**
     * 客户中心
     */
    public static class CustomerClue {
        //生成线索code的redis
        public static final String CLUE_CODE_NO = "CLUE:CODE:NO";
    }

    /**
     * BOSS常量
     */
    public static class BOSSConstant {
        //城市int类型值
        public static final Integer CITY_VALUE = 999;
        //人员
        public static final Integer EMP_VALUE = 1000;
        //公司名
        public static final String COMPANY_SHOW = "子公司";
    }

    /**
     * app指定字段颜色显示
     */
    public static class Color {
        // 红色
        public static final String RED = "#dd2534";
    }

    /**
     * 文件后缀类型
     */
    public static class FileType {
        public static final String XLSX = ".xlsx";
        public static final String JPG = ".jpg";
        public static final String JPG_UPPER = ".JPG";
        public static final String JPEG = ".jpeg";
        public static final String JPEG_UPPER = ".JPEG";
        public static final String PNG = ".png";
        public static final String PNG_UPPER = ".PNG";
        public static final String MP4 = ".mp4";
        public static final String MP4_UPPER = ".MP4";
        public static final String RM = ".rm";
        public static final String RM_UPPER = ".RM";
        public static final String RMVB = ".rmvb";
        public static final String RMVB_UPPER = ".RMVB";
    }

    /**
     * 编码类型
     */
    public static class EncodeType {
        public static final String UTF_8 = "UTF-8";
    }

    /**
     * 保存文件所在路径的key，eg.FILE_MD5:1243jkalsjflkwaejklgjawe
     */
    public static final String FILE_MD5_KEY = "FILE_MD5:";
    /**
     * 保存上传文件的状态
     */
    public static final String FILE_UPLOAD_STATUS = "FILE_UPLOAD_STATUS";
    /**
     * 组织权限
     */
    public static class OfficePermission{
        /**
         * 查看失效组织权限
         */
        public static final String SHOW_INVALID = "structure:office:show:invalid";

        /**
         * 伙伴集团id
         */
        public static final String ROOT_OFFICE_ID = "9c96cc062560438998ed5022993e4184";
    }

    /**
     * 机构性质类型
     */
    public static class OfficeNatureType {
        /** 实际组织 */
        public static final Integer ACTUAL = 0;
        /** 预添加组织 */
        public static final Integer PRE_ADD = 1;
    }

    /**
     * excel工具使用常量
     */
    public static class Excel {
        //excel换行符
        public static final String LINE_SYMBOL = String.valueOf((char)10);
    }

    /**
     * 符号常量
     */
    public static class Unit {
        //中文平方米单位
        public static final String M2_CN = "平方米";
    }

    /**
     * 正则表达式
     */
    public static class Regex {
        //数字类型保留一位小数
        public static final String FLOAT_ONE_REGEX = "^(([1-9]{1}\\\\d*)|([0]{1}))(\\\\.(\\\\d){0,1})?$";
        //数字类型保留两位小数
        public static final String FLOAT_TWO_REGEX = "^(([1-9]{1}\\\\d*)|([0]{1}))(\\\\.(\\\\d){0,2})?$";
    }

    public static class MenuConstant{
        /**
         * 用户菜单
         */
        public static final String SESSION_USER_MENU_TREE = "SYS:CACHE:USER:MENUTREE:";

        /**
         * 目录列表key
         */
        public static final String CACHE_MENU_LIST = "SYS:CACHE:MENULIST:NEW:";
    }

    /**
     * 公司证照
     */
    //证照所属公司人事行政负责人
    public static final  String REN_SHI_XING_ZHENG_BU = "LicenceRenShiXingZhengBuLeader";
    public static final  String REN_SHI_XING_ZHENG_BU_AUDIT_CODE = "RenShiXingZhengBu";
    //证照所属公司财务部负责人
    public static final  String CAI_WU_BU="LicenceCaiWuBuLeader";

    // 员工跨城市异动不清除分机号的城市列表redis缓存（字符串内的城市相互调动不清除分机号）
    public static final String EMPLOYEE_MOVE_EXTENSION_CITY = "EMPLOYEE:MOVE:EXTENSION:CITY";
    // 员工


    /**
     * 数据中心常量
     */
    public static class DataCenter {
        //园区企业源数据表名
        public static final String COMPANY_ORIGIN_TABLE = "t_crawl_company_origin";
    }

    /**
     * 标签常量
     */
    public static class Tag {
        //div标签
        public static final String DIV = "div";
        //a标签
        public static final String A = "a";
        //span标签
        public static final String SPAN = "span";
        //p标签
        public static final String P = "p";
        //标签标题
        public static final String TITLE = "title";
    }
}
