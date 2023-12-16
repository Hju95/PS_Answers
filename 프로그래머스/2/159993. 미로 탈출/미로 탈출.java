import java.util.*;

class Solution {
    static class Point {
        int x;
        int y;
        int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;
        int exitX = 0, exitY = 0;

        // 미로 정보를 순회하면서 시작 지점, 레버 위치, 출구 위치를 찾음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                } else if (maps[i].charAt(j) == 'L') {
                    leverX = i;
                    leverY = j;
                } else if (maps[i].charAt(j) == 'E') {
                    exitX = i;
                    exitY = j;
                }
            }
        }

        // 레버를 먼저 찾음
        queue.offer(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        int leverTime = 0;
        boolean foundLever = false;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == leverX && current.y == leverY) {
                leverTime = current.time;
                foundLever = true;
                break; // 레버를 찾으면 종료
            }

            for (int[] dir : directions) {
                int nx = current.x + dir[0];
                int ny = current.y + dir[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    queue.offer(new Point(nx, ny, current.time + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        if (!foundLever) {
            return -1; // 레버를 찾지 못한 경우 -1 반환
        }

        // 출구까지의 최단 거리 계산
        visited = new boolean[n][m];
        queue.clear();
        queue.offer(new Point(leverX, leverY, leverTime));
        visited[leverX][leverY] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == exitX && current.y == exitY) {
                return current.time; // 출구에 도착하면 시간 반환
            }

            for (int[] dir : directions) {
                int nx = current.x + dir[0];
                int ny = current.y + dir[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    queue.offer(new Point(nx, ny, current.time + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return -1; // 출구로 갈 수 없는 경우 -1 반환
    }
}
