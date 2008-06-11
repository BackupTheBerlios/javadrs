package com.drs.client.test;

import java.util.*;

import com.drs.model.DiskInfo;
import com.drs.model.DiskTag;

public class DiskInfoTest {

	public static List<DiskInfo> createTestData() {
		List<DiskInfo> data = new LinkedList<DiskInfo>();

		DiskInfo di1 = new DiskInfo("aqdky", "爱情大考验");
		di1.setDiskType(DiskInfo.DiskType.VCD);
		DiskInfo di2 = new DiskInfo("gjbz", "国家宝藏");
		di2.setDiskType(DiskInfo.DiskType.DVD);
		DiskInfo di3 = new DiskInfo("ymxcl", "亚马逊丛林");
		di3.setDiskType(DiskInfo.DiskType.VCD);
		DiskInfo di4 = new DiskInfo("ymxkl", "亚马逊恐龙");
		di4.setDiskType(DiskInfo.DiskType.DVD);
		Set<String> actors = new TreeSet<String>();
		actors.add("Actor1");
		actors.add("Actor2");
		actors.add("Actor3");

		Set<DiskTag> diskTagSet = new HashSet<DiskTag>();
		diskTagSet.add(new DiskTag(1, "tag1", "Hot Movie"));
		diskTagSet.add(new DiskTag(2, "tag2", "American Movie"));

		di1.setActors(actors);

		di1.setDiskTagSet(diskTagSet);

		data.add(di1);
		data.add(di2);
		di2.setActors(actors);

		di2.setDiskTagSet(diskTagSet);
		data.add(di3);
		di3.setActors(actors);

		di3.setDiskTagSet(diskTagSet);
		data.add(di4);

		di4.setActors(actors);

		di4.setDiskTagSet(diskTagSet);
		return data;
	}

	public static List<DiskInfo> filter(List<DiskInfo> data, String qt) {

		Iterator<DiskInfo> i = data.iterator();

		while (i.hasNext()) {
			DiskInfo di = i.next();
			if (!di.getId().startsWith(qt)) {
				i.remove();
			}
		}

		Collections.sort(data, new Comparator<DiskInfo>() {

			/**
			 * The most matching object should be placed first.
			 * 
			 * @param o1
			 * @param o2
			 * @return
			 */

			public int compare(DiskInfo o1, DiskInfo o2) {

				return o1.getId().compareTo(o2.getId());
			}

		});

		return data;
	}

}
