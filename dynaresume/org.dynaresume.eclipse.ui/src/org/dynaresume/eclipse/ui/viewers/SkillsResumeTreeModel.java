package org.dynaresume.eclipse.ui.viewers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dynaresume.domain.hr.Resume;
import org.dynaresume.domain.hr.SkillCategory;
import org.dynaresume.domain.hr.SkillResume;

public class SkillsResumeTreeModel {

	private final Resume resume;
	private final List<SkillCategoryWrapper> rootCategories;
	private final Map<SkillCategory, SkillCategoryWrapper> categories;
	private final Map<SkillCategory, Collection<SkillResume>> skillsResumeCache;

	public SkillsResumeTreeModel(Iterable<SkillCategory> categories,
			Resume resume) {
		this.resume = resume;
		Set<SkillResume> skills = resume.getSkills();
		if (skills == null) {
			resume.setSkills(new HashSet<SkillResume>());
			this.skillsResumeCache = new HashMap<SkillCategory, Collection<SkillResume>>();
		} else {
			this.skillsResumeCache = new HashMap<SkillCategory, Collection<SkillResume>>();
			SkillCategory category = null;
			for (SkillResume skillResume : skills) {
				category = skillResume.getCategory();
				Collection<SkillResume> skillResumes = skillsResumeCache
						.get(category);
				if (skillResumes == null) {
					skillResumes = new ArrayList<SkillResume>();
					skillsResumeCache.put(category, skillResumes);
				}
				skillResumes.add(skillResume);
			}
		}

		if (categories != null) {
			this.rootCategories = new ArrayList<SkillCategoryWrapper>();
			this.categories = new LinkedHashMap<SkillCategory, SkillCategoryWrapper>();
			for (SkillCategory category : categories) {
				getCategoryWrapper(category);
			}
		} else {
			this.categories = Collections.emptyMap();
			this.rootCategories = Collections.emptyList();
		}

	}

	public Iterable<SkillCategoryWrapper> getCategories() {
		return rootCategories;
	}

	public SkillCategoryWrapper getCategoryWrapper(SkillCategory category) {
		SkillCategoryWrapper wrapper = categories.get(category);
		if (wrapper == null) {
			wrapper = new SkillCategoryWrapper(this, category);
			this.categories.put(wrapper.getCategory(), wrapper);
			if (category.getParent() != null) {
				SkillCategoryWrapper parentWrapper = getCategoryWrapper(category
						.getParent());
				parentWrapper.addChild(wrapper);
			} else {
				rootCategories.add(wrapper);
			}
		}
		return wrapper;
	}

	public Collection<SkillResume> getSkillsResume(SkillCategory category) {
		return skillsResumeCache.get(category);
	}

	public void removeSkill(SkillResume skill) {
		skillsResumeCache.remove(skill);
		resume.getSkills().remove(skill);
	}

}
