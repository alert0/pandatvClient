package name.yumao.douyu.vo;

public class PandaInfo {

    public static int STREAM_TYPE_360 = 1;
    public static int STREAM_TYPE_UNKNOWN = 0;
	
	
	
	
	
	@Override
	public String toString() {
		return "PandaInfo [errno=" + errno + ", data=" + data + ", errmsg="
				+ errmsg + "]";
	}

	private int errno;
	private DataEntity data;
	private String errmsg;

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public void setData(DataEntity data) {
		this.data = data;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public int getErrno() {
		return errno;
	}

	public DataEntity getData() {
		return data;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public class DataEntity {
		@Override
		public String toString() {
			return "DataEntity [info=" + info + "]";
		}

		/**
		 * info : {"chatinfo":{"appid":"116112055","sign":
		 * "122689b9816522a0bb531ccd3a4d973a"
		 * ,"rid":-71950056,"chat_addr_list":["106.38.192.130:80"
		 * ,"106.38.192.130:80"
		 * ],"ts":"1447079475203","authtype":"3"},"videoinfo"
		 * :{"name":"dota","stream_addr"
		 * :{"SD":"1","OD":"1","HD":"1"},"plflag":"2_3"
		 * ,"sign":"sign","time":"8478"
		 * ,"room_key":"98136e97f549e01b24095ad85bbeb12f"
		 * ,"status":"2","ts":"ts"}
		 * ,"hostinfo":{"name":"周二珂","bamboos":"112998431"
		 * ,"avatar":"http://i1.pdim.gs/t0106940d22461af490.jpg"
		 * ,"rid":3010906},"roominfo"
		 * :{"person_num":"149802","remind_time":"0","remind_status"
		 * :"0","name":"你的月亮我的珂 (ノ｀Д)ノ","remind_content":"","details":"
		 * <p>
		 * 新浪微博：周二珂<\/p>","id":"35723","type":"1","bulletin":"","fans":"135991
		 * "},"
		 * userinfo":{"identity":"30","is_followed":"0","sp_identity":"","rid
		 * ":-71950056}}
		 */
		private InfoEntity info;

		public void setInfo(InfoEntity info) {
			this.info = info;
		}

		public InfoEntity getInfo() {
			return info;
		}

		public class InfoEntity {
			/**
			 * chatinfo :
			 * {"appid":"116112055","sign":"122689b9816522a0bb531ccd3a4d973a"
			 * ,"rid":-71950056,"chat_addr_list":["106.38.192.130:80",
			 * "106.38.192.130:80"],"ts":"1447079475203","authtype":"3"}
			 * videoinfo :
			 * {"name":"dota","stream_addr":{"SD":"1","OD":"1","HD":"1"
			 * },"plflag":"2_3","sign":"sign","time":"8478","room_key":
			 * "98136e97f549e01b24095ad85bbeb12f","status":"2","ts":"ts"}
			 * hostinfo : {"name":"周二珂","bamboos":"112998431","avatar":
			 * "http://i1.pdim.gs/t0106940d22461af490.jpg","rid":3010906}
			 * roominfo :
			 * {"person_num":"149802","remind_time":"0","remind_status"
			 * :"0","name":"你的月亮我的珂 (ノ｀Д)ノ","remind_content":"","details":"
			 * <p>
			 * 新浪微博：周二珂<\/p>","id":"35723","type":"1","bulletin":"","fans":"
			 * 135991"} userinfo :
			 * {"identity":"30","is_followed":"0","sp_identity"
			 * :"","rid":-71950056}
			 */
			private ChatinfoEntity chatinfo;
			private VideoinfoEntity videoinfo;
			private HostinfoEntity hostinfo;
			private RoominfoEntity roominfo;
			private UserinfoEntity userinfo;

			@Override
			public String toString() {
				return "InfoEntity [chatinfo=" + chatinfo + ", videoinfo="
						+ videoinfo + ", hostinfo=" + hostinfo + ", roominfo="
						+ roominfo + ", userinfo=" + userinfo + "]";
			}

			public void setChatinfo(ChatinfoEntity chatinfo) {
				this.chatinfo = chatinfo;
			}

			public void setVideoinfo(VideoinfoEntity videoinfo) {
				this.videoinfo = videoinfo;
			}

			public void setHostinfo(HostinfoEntity hostinfo) {
				this.hostinfo = hostinfo;
			}

			public void setRoominfo(RoominfoEntity roominfo) {
				this.roominfo = roominfo;
			}

			public void setUserinfo(UserinfoEntity userinfo) {
				this.userinfo = userinfo;
			}

			public ChatinfoEntity getChatinfo() {
				return chatinfo;
			}

			public VideoinfoEntity getVideoinfo() {
				return videoinfo;
			}

			public HostinfoEntity getHostinfo() {
				return hostinfo;
			}

			public RoominfoEntity getRoominfo() {
				return roominfo;
			}

			public UserinfoEntity getUserinfo() {
				return userinfo;
			}

			public class ChatinfoEntity {
				@Override
				public String toString() {
					return "ChatinfoEntity [appid=" + appid + ", sign=" + sign
							+ ", rid=" + rid + ", chat_addr_list="
							+ chat_addr_list + ", ts=" + ts + ", authtype="
							+ authtype + "]";
				}

				/**
				 * appid : 116112055 sign : 122689b9816522a0bb531ccd3a4d973a rid
				 * : -71950056 chat_addr_list :
				 * ["106.38.192.130:80","106.38.192.130:80"] ts : 1447079475203
				 * authtype : 3
				 */
				private String appid;
				private String sign;
				private int rid;
				private java.util.List<String> chat_addr_list;
				private String ts;
				private String authtype;

				public void setAppid(String appid) {
					this.appid = appid;
				}

				public void setSign(String sign) {
					this.sign = sign;
				}

				public void setRid(int rid) {
					this.rid = rid;
				}

				public void setChat_addr_list(
						java.util.List<String> chat_addr_list) {
					this.chat_addr_list = chat_addr_list;
				}

				public void setTs(String ts) {
					this.ts = ts;
				}

				public void setAuthtype(String authtype) {
					this.authtype = authtype;
				}

				public String getAppid() {
					return appid;
				}

				public String getSign() {
					return sign;
				}

				public int getRid() {
					return rid;
				}

				public java.util.List<String> getChat_addr_list() {
					return chat_addr_list;
				}

				public String getTs() {
					return ts;
				}

				public String getAuthtype() {
					return authtype;
				}
			}

			public class VideoinfoEntity {
				@Override
				public String toString() {
					return "VideoinfoEntity [name=" + name + ", stream_addr="
							+ stream_addr + ", plflag=" + plflag + ", sign="
							+ sign + ", time=" + time + ", room_key="
							+ room_key + ", status=" + status + ", ts=" + ts
							+ "]";
				}
				

				
				
				 public boolean getStreamAddress(String strStreamType, StringBuffer strAddress) {
				        boolean v4 = true;
				        int v1 = 0;
				        String v2 = "";
				        try {
				            String[] v3 = this.plflag.split("_");
				            if(v3.length > 0 && !v3[0].isEmpty()) {
				                v1 = Integer.parseInt(v3[0]);
				            }

				            if(v3.length > 1) {
				                v2 = v3[1];
				            }

				            if(v1 == STREAM_TYPE_UNKNOWN) {
				                return false;
				            }

				            if(v1 == STREAM_TYPE_360) {
				                return v4;
				            }

				            strAddress.append(String.format("http://pl%s.live.panda.tv/live_panda/%s%s.flv", v2, this.room_key, strStreamType));
				            return v4;
				        }
				        catch(Exception v0) {
				            v0.printStackTrace();
				        }

				        return false;
				    }


				/**
				 * name : dota stream_addr : {"SD":"1","OD":"1","HD":"1"} plflag
				 * : 2_3 sign : sign time : 8478 room_key :
				 * 98136e97f549e01b24095ad85bbeb12f status : 2 ts : ts
				 */
				private String name;
				private Stream_addrEntity stream_addr;
				private String plflag;
				private String sign;
				private String time;
				private String room_key;
				private String status;
				private String ts;

				public void setName(String name) {
					this.name = name;
				}

				public void setStream_addr(Stream_addrEntity stream_addr) {
					this.stream_addr = stream_addr;
				}

				public void setPlflag(String plflag) {
					this.plflag = plflag;
				}

				public void setSign(String sign) {
					this.sign = sign;
				}

				public void setTime(String time) {
					this.time = time;
				}

				public void setRoom_key(String room_key) {
					this.room_key = room_key;
				}

				public void setStatus(String status) {
					this.status = status;
				}

				public void setTs(String ts) {
					this.ts = ts;
				}

				public String getName() {
					return name;
				}

				public Stream_addrEntity getStream_addr() {
					return stream_addr;
				}

				public String getPlflag() {
					return plflag;
				}

				public String getSign() {
					return sign;
				}

				public String getTime() {
					return time;
				}

				public String getRoom_key() {
					return room_key;
				}

				public String getStatus() {
					return status;
				}

				public String getTs() {
					return ts;
				}

				public class Stream_addrEntity {
					/**
					 * SD : 1 OD : 1 HD : 1
					 */
					private String SD;
					private String OD;
					private String HD;

					public void setSD(String SD) {
						this.SD = SD;
					}

					public void setOD(String OD) {
						this.OD = OD;
					}

					public void setHD(String HD) {
						this.HD = HD;
					}

					public String getSD() {
						return SD;
					}

					public String getOD() {
						return OD;
					}

					public String getHD() {
						return HD;
					}
				}
				
			
				
				
			}

			public class HostinfoEntity {
				@Override
				public String toString() {
					return "HostinfoEntity [name=" + name + ", bamboos="
							+ bamboos + ", avatar=" + avatar + ", rid=" + rid
							+ "]";
				}

				/**
				 * name : 周二珂 bamboos : 112998431 avatar :
				 * http://i1.pdim.gs/t0106940d22461af490.jpg rid : 3010906
				 */
				private String name;
				private String bamboos;
				private String avatar;
				private int rid;

				public void setName(String name) {
					this.name = name;
				}

				public void setBamboos(String bamboos) {
					this.bamboos = bamboos;
				}

				public void setAvatar(String avatar) {
					this.avatar = avatar;
				}

				public void setRid(int rid) {
					this.rid = rid;
				}

				public String getName() {
					return name;
				}

				public String getBamboos() {
					return bamboos;
				}

				public String getAvatar() {
					return avatar;
				}

				public int getRid() {
					return rid;
				}
			}

			public class RoominfoEntity {
				@Override
				public String toString() {
					return "RoominfoEntity [person_num=" + person_num
							+ ", remind_time=" + remind_time
							+ ", remind_status=" + remind_status + ", name="
							+ name + ", remind_content=" + remind_content
							+ ", details=" + details + ", id=" + id + ", type="
							+ type + ", bulletin=" + bulletin + ", fans="
							+ fans + "]";
				}

				/**
				 * person_num : 149802 remind_time : 0 remind_status : 0 name :
				 * 你的月亮我的珂 (ノ｀Д)ノ remind_content : details :
				 * <p>
				 * 新浪微博：周二珂
				 * </p>
				 * id : 35723 type : 1 bulletin : fans : 135991
				 */
				private String person_num;
				private String remind_time;
				private String remind_status;
				private String name;
				private String remind_content;
				private String details;
				private String id;
				private String type;
				private String bulletin;
				private String fans;

				public void setPerson_num(String person_num) {
					this.person_num = person_num;
				}

				public void setRemind_time(String remind_time) {
					this.remind_time = remind_time;
				}

				public void setRemind_status(String remind_status) {
					this.remind_status = remind_status;
				}

				public void setName(String name) {
					this.name = name;
				}

				public void setRemind_content(String remind_content) {
					this.remind_content = remind_content;
				}

				public void setDetails(String details) {
					this.details = details;
				}

				public void setId(String id) {
					this.id = id;
				}

				public void setType(String type) {
					this.type = type;
				}

				public void setBulletin(String bulletin) {
					this.bulletin = bulletin;
				}

				public void setFans(String fans) {
					this.fans = fans;
				}

				public String getPerson_num() {
					return person_num;
				}

				public String getRemind_time() {
					return remind_time;
				}

				public String getRemind_status() {
					return remind_status;
				}

				public String getName() {
					return name;
				}

				public String getRemind_content() {
					return remind_content;
				}

				public String getDetails() {
					return details;
				}

				public String getId() {
					return id;
				}

				public String getType() {
					return type;
				}

				public String getBulletin() {
					return bulletin;
				}

				public String getFans() {
					return fans;
				}
			}

			public class UserinfoEntity {
				/**
				 * identity : 30 is_followed : 0 sp_identity : rid : -71950056
				 */
				private String identity;
				private String is_followed;
				private String sp_identity;
				private int rid;

				public void setIdentity(String identity) {
					this.identity = identity;
				}

				public void setIs_followed(String is_followed) {
					this.is_followed = is_followed;
				}

				public void setSp_identity(String sp_identity) {
					this.sp_identity = sp_identity;
				}

				public void setRid(int rid) {
					this.rid = rid;
				}

				public String getIdentity() {
					return identity;
				}

				public String getIs_followed() {
					return is_followed;
				}

				public String getSp_identity() {
					return sp_identity;
				}

				public int getRid() {
					return rid;
				}
			}
		}
	}
}
