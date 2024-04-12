package com.bori.project31.service;

import com.bori.project31.model.CheckRequest;
import org.springframework.stereotype.Service;



@Service
public class CalculateAccuracyService {

	// 문자열 유사성 알고리즘 *Levenshtein Distance
	public int calculateLVD(CheckRequest checkReq) {
		String str1 = checkReq.getQuest();
		String str2 = checkReq.getInputText();
		
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Input strings must not be null");
        }
        
        int len1 = str1.length();
        int len2 = str2.length();

		int[][] distance = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			distance[i][0] = i;
		}
		for (int j = 0; j <= len2; j++) {
			distance[0][j] = j;
		}

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				int cost = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1;
				distance[i][j] = Math.min(Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1),
						distance[i - 1][j - 1] + cost);
			}
		}

		return distance[len1][len2];
	}

}
