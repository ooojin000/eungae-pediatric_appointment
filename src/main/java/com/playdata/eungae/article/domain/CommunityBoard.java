package com.playdata.eungae.article.domain;

import com.playdata.eungae.base.BaseEntity;
import com.playdata.eungae.member.domain.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "community_board")
public class CommunityBoard extends BaseEntity {

	@Id
	@GeneratedValue
	private Long communityBoardSeq;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_seq")
	private Member member;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;



	public void setMember(Member member) {
		this.member = member;
	}

	public void setTitle(String title) { this.title = title;
	}
	public void setContent(String content) { this.content = content;
	}
}