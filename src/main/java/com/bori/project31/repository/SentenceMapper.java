package com.bori.project31.repository;

import java.util.List;

import com.bori.project31.model.Sentence;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SentenceMapper {

	public void insertSentence(Sentence sentence);
	public void updateSentence(Sentence sentence);
	public int countSent();
	public Sentence selectForGame(int sno);
}
