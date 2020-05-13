package com.ouc.entity;

public class Zhidu {
    private Integer id;
	private String shetuanbianhao;
	private String shetuanmingcheng;
	private String leibie;
	private String zhangjie;
	private String zhidumingcheng;
	private String zhiduneirong;
	private String dengjiren;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShetuanbianhao() {
        return shetuanbianhao;
    }
    public void setShetuanbianhao(String shetuanbianhao) {
        this.shetuanbianhao = shetuanbianhao == null ? null : shetuanbianhao.trim();
    }
	public String getShetuanmingcheng() {
        return shetuanmingcheng;
    }
    public void setShetuanmingcheng(String shetuanmingcheng) {
        this.shetuanmingcheng = shetuanmingcheng == null ? null : shetuanmingcheng.trim();
    }
	public String getLeibie() {
        return leibie;
    }
    public void setLeibie(String leibie) {
        this.leibie = leibie == null ? null : leibie.trim();
    }
	public String getZhangjie() {
        return zhangjie;
    }
    public void setZhangjie(String zhangjie) {
        this.zhangjie = zhangjie == null ? null : zhangjie.trim();
    }
	public String getZhidumingcheng() {
        return zhidumingcheng;
    }
    public void setZhidumingcheng(String zhidumingcheng) {
        this.zhidumingcheng = zhidumingcheng == null ? null : zhidumingcheng.trim();
    }
	public String getZhiduneirong() {
        return zhiduneirong;
    }
    public void setZhiduneirong(String zhiduneirong) {
        this.zhiduneirong = zhiduneirong == null ? null : zhiduneirong.trim();
    }
	public String getDengjiren() {
        return dengjiren;
    }
    public void setDengjiren(String dengjiren) {
        this.dengjiren = dengjiren == null ? null : dengjiren.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
