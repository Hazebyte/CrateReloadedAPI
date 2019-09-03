package com.hazebyte.crate.api.crate.reward;

import com.google.common.base.Strings;
import com.hazebyte.crate.api.util.Messenger;
import com.hazebyte.crate.api.util.Messages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RewardLine {

	private String rewardString;

	public RewardLine(String rewardString) {
		this.rewardString = rewardString.trim();
	}

	public RewardLine(RewardLine copy) {
	    this.rewardString = copy.getRewardString();
    }

	public String getRewardString() {
	    return rewardString;
    }

	public boolean isEmpty() {
	    return Strings.isNullOrEmpty(rewardString);
    }
	
	public Map<Tag, List<String>> parse() {
		String parts[] = splitTags();
		Map<Tag, List<String>> settings = new HashMap<>();
		for(String currentLine: parts) {
			if(currentLine == null) {
				continue; 
			}
			
			int firstChar = 0;
			int tagCut = currentLine.indexOf(":");
			int firstSection = currentLine.indexOf("(") + 1;
			int secondSection = currentLine.lastIndexOf(")");
			
			String tagValue = null;
			Tag tag = null;
			String section = null;
			try {
				tagValue = currentLine.substring(firstChar, tagCut).toLowerCase();
				tag = Tag.getTagFromValue(tagValue);
				section = currentLine.substring(firstSection, secondSection);
			} catch(Exception e) {
				Messenger.info(String.format(Messages.ERROR_LINE, currentLine));
			}

			List<String> stringList;
			if((stringList = settings.get(tag)) == null) {
				stringList = new ArrayList<>();
				stringList.add(section);
				settings.put(tag, stringList);
			} else {
				stringList.add(section);
				settings.put(tag, stringList);
			}
		}
		return settings;
	}

	public String[] splitTags() {
		String[] parts = rewardString.split(",");
		List<Integer> brokenParts = new ArrayList<>();
		for (int i = 0; i < parts.length; i++) {
			String current = parts[i];

			if (!Tag.contains(current)) {
				brokenParts.add(i);
			}
		}
		
		String[] newParts = new String[parts.length - brokenParts.size()];
		int stringCounter = 0;
		iteration:
		for(int i = 0; i < parts.length; i++) {
			for(int j = 0; j < brokenParts.size(); j++) {
				if(brokenParts.get(j) == i) {
					try {
						newParts[stringCounter - 1] += "," + parts[i];
					} catch(ArrayIndexOutOfBoundsException e) {
						Messenger.info(String.format("%s\"%s\" from \"%s\"", Messages.ERROR_LINE, parts[i].trim(), rewardString.trim()));
					}
					continue iteration;
				}
			}
			
			newParts[stringCounter] = parts[i];
			stringCounter++;
		}
		
		return Messenger.trim(newParts);
	}

	@Override
	public String toString() {
		return this.rewardString;
	}
}
