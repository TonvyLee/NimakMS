package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_MESSAGE:
 */
@Entity
@Table(name = "BDF2_MESSAGE")
public class Bdf2Message implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id_:
	 */
	@PropertyDef(label = "id_", description = "id_:")
	private String id;

	/**
	 * content_:
	 */
	@PropertyDef(label = "content_", description = "content_:")
	private String content;

	/**
	 * read_:
	 */
	@PropertyDef(label = "read_", description = "read_:")
	private boolean read;

	/**
	 * receiver_:
	 */
	@PropertyDef(label = "receiver_", description = "receiver_:")
	private String receiver;

	/**
	 * reply_:
	 */
	@PropertyDef(label = "reply_", description = "reply_:")
	private boolean reply;

	/**
	 * send_date_:
	 */
	@PropertyDef(label = "send_date_", description = "send_date_:")
	private Date sendDate;

	/**
	 * sender_:
	 */
	@PropertyDef(label = "sender_", description = "sender_:")
	private String sender;

	/**
	 * tags_:
	 */
	@PropertyDef(label = "tags_", description = "tags_:")
	private String tags;

	/**
	 * title_:
	 */
	@PropertyDef(label = "title_", description = "title_:")
	private String title;

	public Bdf2Message() {
		super();
	}

	public Bdf2Message(String id, String content, boolean read,
			String receiver, boolean reply, Date sendDate, String sender,
			String tags, String title) {
		super();
		this.id = id;
		this.content = content;
		this.read = read;
		this.receiver = receiver;
		this.reply = reply;
		this.sendDate = sendDate;
		this.sender = sender;
		this.tags = tags;
		this.title = title;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "id_", length = 120, nullable = false)
	public String getId() {
		return id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "content_", length = 2000, nullable = false)
	public String getContent() {
		return content;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	@Column(name = "read_", nullable = false)
	public boolean isRead() {
		return read;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Column(name = "receiver_", length = 120, nullable = false)
	public String getReceiver() {
		return receiver;
	}

	public void setReply(boolean reply) {
		this.reply = reply;
	}

	@Column(name = "reply_")
	public boolean isReply() {
		return reply;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "send_date_")
	public Date getSendDate() {
		return sendDate;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Column(name = "sender_", length = 120, nullable = false)
	public String getSender() {
		return sender;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Column(name = "tags_", length = 200)
	public String getTags() {
		return tags;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "title_", length = 120, nullable = false)
	public String getTitle() {
		return title;
	}

	public String toString() {
		return "Bdf2Message [id=" + id + ",content=" + content + ",read="
				+ read + ",receiver=" + receiver + ",reply=" + reply
				+ ",sendDate=" + sendDate + ",sender=" + sender + ",tags="
				+ tags + ",title=" + title + "]";
	}

}
